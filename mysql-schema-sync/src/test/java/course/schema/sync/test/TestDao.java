package course.schema.sync.test;

import course.schema.sync.dao.DaoFacade;
import course.schema.sync.mapper.ColumnsMapper;
import course.schema.sync.mapper.SchemaMapper;
import course.schema.sync.mapper.StatisticsMapper;
import course.schema.sync.mapper.TablesMapper;
import course.schema.sync.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public class TestDao {

    private ConnectInfo connectInfo;

    @Before
    public void init() {
        connectInfo = new ConnectInfo();
        connectInfo.setUrl("jdbc:mysql://127.0.0.1:3306");
        connectInfo.setUserName("root");
        connectInfo.setPassword("123456");
    }

    @Test
    public void testSchema() {
        Set<SchemaDO> schemas = DaoFacade.ofMapper(connectInfo, SchemaMapper.class, SchemaMapper::selectAllSchema);
        schemas.forEach(System.out::println);
    }

    @Test
    public void testTables() {
        Set<TablesDO> tables = DaoFacade.ofMapper(connectInfo, TablesMapper.class, mapper -> mapper.
                selectByTableSchema("course"));

        for (TablesDO tab : tables) {
            System.out.println("tab = " + tab);
        }
    }

    @Test
    public void testColumns() {
        Set<ColumnsDO> columns = DaoFacade.ofMapper(connectInfo, ColumnsMapper.class, mapper -> mapper.selectByTable("course", "tb_user"));
        for (ColumnsDO column : columns) {
            System.out.println("column = " + column);
        }
    }

    @Test
    public void testStatistics() {
        Set<StatisticsDO> statistics = DaoFacade.ofMapper(connectInfo, StatisticsMapper.class, mapper -> mapper.selectByTable("course", "tb_user"));
        for (StatisticsDO statistic : statistics) {
            System.out.println("statistic = " + statistic);
        }
    }

    @Test
    public void testExecSql() {
        DaoFacade.execSql(connectInfo, "alter table course.tb_user modify column xyz varchar(450) not null default 'y' comment 'hahahah 12345 test';");
    }

    @Test
    public void testShowCreateTable() {
        String sql = DaoFacade.showCreateTable(connectInfo, "course", "tb_user");

        System.out.println("sql = " + sql);
    }


}
