package course.schema.sync.service.impl;

import com.google.common.base.Joiner;
import com.google.common.collect.*;
import course.schema.sync.consts.SqlFormatterConst;
import course.schema.sync.dao.DaoFacade;
import course.schema.sync.mapper.ColumnsMapper;
import course.schema.sync.mapper.StatisticsMapper;
import course.schema.sync.model.*;
import course.schema.sync.service.SyncService;
import course.schema.sync.util.SqlUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
@Service
public class SyncServiceImpl implements SyncService {

    @Override
    public void syncInstance(SyncInstanceRequest syncInfo) {

    }

    @Override
    public void syncDatabase(SyncDatabaseRequest syncInfo) {

    }

    @Override
    public void syncTable(SyncTableRequest syncInfo) {
        // 同步字段
        syncColumns(syncInfo);

        // 同步索引
        syncStatistics(syncInfo);
    }

    private void syncStatistics(SyncTableRequest syncInfo) {
        // 1.取出连接信息
        ConnectInfo srcConnectInfo = syncInfo.getSrcConnectInfo();
        ConnectInfo dstConnectInfo = syncInfo.getDstConnectInfo();

        // 2.查询库.表的索引信息
        Set<StatisticsDO> srcStatistics = DaoFacade.ofMapper(srcConnectInfo, StatisticsMapper.class, mapper -> mapper.selectByTable(syncInfo.getDatabaseName(), syncInfo.getTableName()));
        Set<StatisticsDO> dstStatistics = DaoFacade.ofMapper(dstConnectInfo, StatisticsMapper.class, mapper -> mapper.selectByTable(syncInfo.getDatabaseName(), syncInfo.getTableName()));

        // 3.diff 索引差异 并生成对应的 indexModel 集合
        Map<Boolean, List<IndexModel>> indexModelMap = diffStatisticsForIndexModel(srcStatistics, dstStatistics);
        List<IndexModel> preparedCreateIndexModel = indexModelMap.get(Boolean.TRUE);
        List<IndexModel> preparedModifyIndexModel = indexModelMap.get(Boolean.FALSE);

        // 4.执行新建
        List<String> createIndexSql = getCreateIndexSql(preparedCreateIndexModel);
        execSql(dstConnectInfo, createIndexSql);

        // 5.生成 删除SQL 并执行
        List<String> dropIndexSql = getDropIndexSql(preparedModifyIndexModel);
        execSql(dstConnectInfo, dropIndexSql);

        // 5.生成创建 SQL 并执行
        List<String> modifyIndexSql = getCreateIndexSql(preparedModifyIndexModel);
        execSql(dstConnectInfo, modifyIndexSql);
    }

    private void syncColumns(SyncTableRequest syncInfo) {
        // 1.取出连接信息
        ConnectInfo srcConnectInfo = syncInfo.getSrcConnectInfo();
        ConnectInfo dstConnectInfo = syncInfo.getDstConnectInfo();

        // 2.查询库.表的字段信息
        Set<ColumnsDO> srcColumns = DaoFacade.ofMapper(srcConnectInfo, ColumnsMapper.class, mapper -> mapper.selectByTable(syncInfo.getDatabaseName(), syncInfo.getTableName()));
        Set<ColumnsDO> dstColumns = DaoFacade.ofMapper(dstConnectInfo, ColumnsMapper.class, mapper -> mapper.selectByTable(syncInfo.getDatabaseName(), syncInfo.getTableName()));

        // 3.diff 字段差异
        List<ColumnsDO> columnDiffInfo = diffColumns(srcColumns, dstColumns);

        // 4.生成差异待修改的字段SQL
        List<String> columnsSql = genColumnSql(columnDiffInfo);

        // 5.执行修改SQL
        execSql(dstConnectInfo, columnsSql);
    }

    private void execSql(ConnectInfo connectInfo, List<String> sqlList) {
        DaoFacade.execBatchSql(connectInfo, sqlList);
    }

    private List<String> genColumnSql(List<ColumnsDO> columnDiffInfo) {
        return columnDiffInfo.stream().map(column -> {
            String format = getFormatForColumnFlag(column.isAdd());
            return new Formatter().format(format, column.getTableSchema(),
                    column.getTableName(),
                    column.getColumnName(),
                    column.getColumnType(),
                    SqlUtils.wrapperNullableSet(column),
                    SqlUtils.wrapperDefaultSet(column),
                    SqlUtils.wrapperCommentSet(column))
                    .toString();
        }).collect(Collectors.toList());
    }

    private String getFormatForColumnFlag(boolean isAdd) {
        return isAdd ? SqlFormatterConst.ADD_COLUMN_FORMAT : SqlFormatterConst.MODIFY_COLUMN_FORMAT;
    }

    private List<ColumnsDO> diffColumns(Set<ColumnsDO> srcColumns, Set<ColumnsDO> dstColumns) {
        /**
         * 对比src 和 dst. 不管是 长度不一致,还是注释,还是默认值; 只要不一致就以src为准,进行同步操作
         * 先判断字段名,即src有,dst无的,即为需要插入的,除此之外就是需要做modify的.
         */
        Set<String> srcColumnNameSet = srcColumns.stream().map(ColumnsDO::getColumnName).collect(Collectors.toSet());
        Set<String> dstColumnNameSet = dstColumns.stream().map(ColumnsDO::getColumnName).collect(Collectors.toSet());

        // 需要做插入的,而非做修改
        Set<String> diffColumnName = Sets.difference(srcColumnNameSet, dstColumnNameSet).immutableCopy();

        return Sets.difference(srcColumns, dstColumns)
                .stream()
                .peek(column -> checkAddFlag(diffColumnName, column))
                .distinct()
                .collect(Collectors.toList());
    }

    private void checkAddFlag(Set<String> diffColumnName, ColumnsDO column) {
        if (diffColumnName.contains(column.getColumnName())) {
            column.setAdd(true);
        }
    }

    private Map<Boolean, List<IndexModel>> diffStatisticsForIndexModel(Set<StatisticsDO> srcStatistics, Set<StatisticsDO> dstStatistics) {
        Set<IndexModel> srcIndexModelSet = parseForIndexModel(srcStatistics);
        Set<IndexModel> dstIndexModelSet = parseForIndexModel(dstStatistics);

        Set<String> srcIndexNameSet = srcIndexModelSet.stream().map(IndexModel::getIndexName).collect(Collectors.toSet());

        Set<String> dstIndexNameSet = dstIndexModelSet.stream().map(IndexModel::getIndexName).collect(Collectors.toSet());

        Set<String> prepareCreateIndexNameSet = Sets.difference(srcIndexNameSet, dstIndexNameSet).immutableCopy();

        Set<IndexModel> diffIndexModels = Sets.difference(srcIndexModelSet, dstIndexModelSet).immutableCopy();

        return diffIndexModels.stream()
                .collect(Collectors.partitioningBy(indexModel -> prepareCreateIndexNameSet.contains(indexModel.getIndexName())));
    }

    private List<String> getDropIndexSql(List<IndexModel> indexModelSet) {
        return indexModelSet.stream().map(indexModel -> new Formatter().format(SqlFormatterConst.DROP_INDEX_FORMAT,
                indexModel.getTableSchema(),
                indexModel.getTableName(),
                indexModel.getIndexName()
        ).toString()).collect(Collectors.toList());
    }

    private List<String> getCreateIndexSql(List<IndexModel> indexModelSet) {
        return indexModelSet.stream().map(indexModel -> {
            String format = indexModel.getNonUnique() == 0 ? SqlFormatterConst.ADD_UNIQUE_INDEX_FORMAT : SqlFormatterConst.ADD_INDEX_FORMAT;
            return new Formatter().format(format,
                    indexModel.getTableSchema(),
                    indexModel.getTableName(),
                    indexModel.getIndexName(),
                    Joiner.on(",").join(indexModel.getColumns()))
                    .toString();
        }).collect(Collectors.toList());
    }

    // 仅供参考吧
//    private List<String> diffStatisticsForSqlOld(Set<StatisticsDO> srcStatistics, Set<StatisticsDO> dstStatistics) {
//        // 先基于索引名字进行分组,相同索引名字的在一个组里，即一个真实的索引
//        Pair<Set<StatisticKey>, ArrayListMultimap<StatisticKey, StatisticsDO>> srcPair = parseStatisticsForPair(srcStatistics);
//        Pair<Set<StatisticKey>, ArrayListMultimap<StatisticKey, StatisticsDO>> dstPair = parseStatisticsForPair(dstStatistics);
//
//        ArrayListMultimap<StatisticKey, StatisticsDO> srcStatisticsMap = srcPair.getRight();
//        ArrayListMultimap<StatisticKey, StatisticsDO> dstStatisticsMap = dstPair.getRight();
//
//        // 最终返回的SQL结果集
//        List<String> results = Lists.newArrayList();
//
//        // diff一下索引的名字,如果src有,dst没有,那就是需要去做新建的。
//        Set<StatisticKey> prepareCreateIndexSet = Sets.difference(srcPair.getLeft(), dstPair.getLeft()).immutableCopy();
//
//        /**
//         * =================================== 生成创建索引的SQL ===================================
//         */
//        List<String> createIndexSql = prepareCreateIndexSet.stream().map(statisticKey -> {
//            // 基于索引名取出此索引名所对应的所有字段。即: uniq_key123 ===> key1,key3,key2
//            List<StatisticsDO> statistics = srcStatisticsMap.get(statisticKey);
//
//            // 对取出的所有字段做排序，uniq_key123 ===> key1,key3,key2 ==》  key1, key2, key3
//            // 排序的依据是 索引每行中的StatisticsDO##getSeqInIndex()
//            statistics.sort(Comparator.comparingInt(StatisticsDO::getSeqInIndex));
//
//            // 排序完了之后，我们做连接操作，即生成 ==》 `key1`,`key2`,`key3`。 eg. alter table xxx add index index_name(`x`,`y`,`z`) => `x`,`y`,`z`  是不是就是我们需要做连接的字段啊
//            String columnList = statistics.stream().map(statistic -> "`" + statistic.getColumnName() + "`").collect(Collectors.joining(","));
//
//            // 我们到底是添加 普通索引，还是唯一索引？ 基于什么做的判断呢？ 就是 statisticKey.getNonUnique()
//            // 如果 getNonUnique(）==0 表示的是 唯一索引。  getNonUnique(）==1 表示的是普通索引
//            String format = getCreateIndexByNonUnique(statisticKey.getNonUnique());
//
//            // 基于format的格式化，做的整合吗。
//            // "alter table `%s`.`%s` add index `%s`(%s);";
//            // "alter table `%s`.`%s` add unique index `%s`(%s);";
//            return new Formatter().format(format,
//                    statisticKey.getTableSchema(),
//                    statisticKey.getTableName(),
//                    statisticKey.getIndexName(),
//                    columnList).toString();
//        }).collect(Collectors.toList());
//        results.addAll(createIndexSql);
//
//
//        /**
//         * =================================== 生成修改索引的SQL ===================================
//         */
//        Set<IndexModel> srcIndexModelSet = parseForIndexModel(srcStatistics);
//        Set<IndexModel> dstIndexModelSet = parseForIndexModel(dstStatistics);
//
//        Set<IndexModel> diffIndexSet = Sets.difference(srcIndexModelSet, dstIndexModelSet).immutableCopy();
//
//        List<String> modifyIndexSql = diffIndexSet.stream()
//                .filter(indexModel -> !prepareCreateIndexSet.stream().map(StatisticKey::getIndexName).collect(Collectors.toList()).contains(indexModel.getIndexName()))
//                .map(indexModel -> {
//                    String format = indexModel.getNonUnique() == 0 ? SqlFormatterConst.MODIFY_UNIQUE_INDEX_FORMAT : SqlFormatterConst.MODIFY_INDEX_FORMAT;
//
//                    return new Formatter().format(format,
//                            indexModel.getTableSchema(),
//                            indexModel.getTableName(),
//                            indexModel.getIndexName(),
//                            Joiner.on(",").join(indexModel.getColumns()))
//                            .toString();
//                }).collect(Collectors.toList());
//
//        results.addAll(modifyIndexSql);
//        return results;
//    }

    private Set<IndexModel> parseForIndexModel(Set<StatisticsDO> statistics) {
        Map<StatisticKey, List<StatisticsDO>> indexKeyGroup = statistics.stream().collect(Collectors.groupingBy(statistic -> StatisticKey.builder()
                .indexName(statistic.getIndexName())
                .nonUnique(statistic.getNonUnique())
                .tableName(statistic.getTableName())
                .tableSchema(statistic.getTableSchema()).build()));

        return indexKeyGroup.entrySet().stream().map(indexGroup -> {
            StatisticKey statisticKey = indexGroup.getKey();
            List<StatisticsDO> scs = indexGroup.getValue();
            List<String> columns = scs.stream().sorted(Comparator.comparingInt(StatisticsDO::getSeqInIndex)).map(StatisticsDO::getColumnName).collect(Collectors.toList());
            return IndexModel.builder()
                    .indexName(statisticKey.getIndexName())
                    .tableSchema(statisticKey.getTableSchema())
                    .tableName(statisticKey.getTableName())
                    .nonUnique(statisticKey.getNonUnique())
                    .columns(columns)
                    .build();
        }).collect(Collectors.toSet());
    }

    /**
     * 1.索引库中存储的数据是 一个复合索引，涉及有多个字段时，就会存多行。与column不一样了，column是一行数据就是一个字段
     * 2.所以。我们一个索引，是多行数据的集合。但是呢，这多行数据，特点是，索引名字一样，每一行数据里，只是 字段名和需要不一致。
     * 3.所以，我拆了一下，indexName ===> [column_name,seq_in_index]. ==> Map<String,List<StatisticsDO>>
     *
     * @param statistics
     * @return
     */
    private Pair<Set<StatisticKey>, ArrayListMultimap<StatisticKey, StatisticsDO>> parseStatisticsForPair(Set<StatisticsDO> statistics) {
        // 本质上就是 Map<String,List<StatisticsDO>>。 太原市了，需要自己判断key是否存在，如果存在往List里add,若果不存在，需要new List然后在put进map
        ArrayListMultimap<StatisticKey, StatisticsDO> statisticsMap = ArrayListMultimap.create();
        Set<StatisticKey> statisticNameSet = Sets.newHashSet();
        for (StatisticsDO statistic : statistics) {
            StatisticKey key = StatisticKey.builder()
                    .indexName(statistic.getIndexName())
                    .nonUnique(statistic.getNonUnique())
                    .tableName(statistic.getTableName())
                    .tableSchema(statistic.getTableSchema())
                    .build();
            statisticsMap.put(key, statistic);
            statisticNameSet.add(key);
        }
        // return a,b
        return Pair.of(statisticNameSet, statisticsMap);
    }
}
