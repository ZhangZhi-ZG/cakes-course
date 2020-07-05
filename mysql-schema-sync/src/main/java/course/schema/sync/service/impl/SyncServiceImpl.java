package course.schema.sync.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import course.schema.sync.dao.DaoFacade;
import course.schema.sync.mapper.ColumnsMapper;
import course.schema.sync.mapper.StatisticsMapper;
import course.schema.sync.model.*;
import course.schema.sync.service.SyncService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        // 取出连接信息
        ConnectInfo srcConnectInfo = syncInfo.getSrcConnectInfo();
        ConnectInfo dstConnectInfo = syncInfo.getDstConnectInfo();

        // 1.去src中找到 对应的实例/数据库/表 获取其字段+索引
        Set<ColumnsDO> srcColumns = DaoFacade.ofMapper(srcConnectInfo, ColumnsMapper.class, mapper -> mapper.selectByTable(syncInfo.getDatabaseName(), syncInfo.getTableName()));
        Set<ColumnsDO> dstColumns = DaoFacade.ofMapper(dstConnectInfo, ColumnsMapper.class, mapper -> mapper.selectByTable(syncInfo.getDatabaseName(), syncInfo.getTableName()));

        // 2.去dst中找到 对应的实例/数据库/表 获取其字段+索引
        Set<StatisticsDO> srcStatistics = DaoFacade.ofMapper(srcConnectInfo, StatisticsMapper.class, mapper -> mapper.selectByTable(syncInfo.getDatabaseName(), syncInfo.getTableName()));
        Set<StatisticsDO> dstStatistics = DaoFacade.ofMapper(dstConnectInfo, StatisticsMapper.class, mapper -> mapper.selectByTable(syncInfo.getDatabaseName(), syncInfo.getTableName()));

        // 3.diff 差异。==》 字段不一致，索引不一致
        List<ColumnsDO> columnDiffInfo = diffColumns(srcColumns, dstColumns);
        List<StatisticsDO> statisticsDiffInfo = diffStatistics(srcStatistics, dstStatistics);

        // test
        System.out.println("\n\n\n");

        for (ColumnsDO columns : columnDiffInfo) {
            System.out.println("diff column = " + columns);
        }

        for (StatisticsDO statisticsDO : statisticsDiffInfo) {
            System.out.println("diff statistics = " + statisticsDO);
        }

        // test

//        // 4.基于差异 =》 生产 SQL
//        List<String> columnsSql = genColumnSql(columnDiffInfo);
//        List<String> statisticsSql = genStatisticsSql(statisticsDiffInfo);
//
//        // 5.执行修改SQL
//        execSql(columnsSql);
//        execSql(statisticsSql);
    }

    private void execSql(List<String> sqlList) {

    }

    private List<String> genColumnSql(Set<ColumnsDO> columnDiffInfo) {
        return null;
    }

    private List<String> genStatisticsSql(Set<StatisticsDO> statisticsDiffInfo) {
        return null;
    }

    private List<ColumnsDO> diffColumns(Set<ColumnsDO> srcColumns, Set<ColumnsDO> dstColumns) {
        // 对比src 和 dst. 不管是 长度不一致,还是注释,还是默认值; 只要不一致就以src为准,进行同步操作
        Set<ColumnsDO> diffColumns = Sets.difference(srcColumns, dstColumns).immutableCopy();

        return new ArrayList<>(diffColumns);
    }

    private List<StatisticsDO> diffStatistics(Set<StatisticsDO> srcStatistics, Set<StatisticsDO> dstStatistics) {
        Set<StatisticsDO> diffColumns = Sets.difference(srcStatistics, dstStatistics).immutableCopy();

        return new ArrayList<>(diffColumns);
    }
}
