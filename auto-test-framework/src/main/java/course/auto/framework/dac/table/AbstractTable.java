package course.auto.framework.dac.table;

import course.auto.framework.dac.builder.StatementBuilder;
import course.auto.framework.dac.service.JdbcService;
import course.auto.framework.dac.sql.SqlGenerator;
import course.auto.framework.model.GenSqlParams;
import course.auto.framework.model.RowEntity;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;

public abstract class AbstractTable {

    protected String dbName;

    protected String tableName;

    public AbstractTable(String dbName, String tableName) {
        this.dbName = dbName;
        this.tableName = tableName;
    }

    public int delete(StatementBuilder statementBuilder) {
        Pair<String, Map<String, Object>> sqlParamPair = SqlGenerator.genDeleteSql(new GenSqlParams(this.dbName, this.tableName, statementBuilder.getFields()));
        return new JdbcService().modify(sqlParamPair.getLeft(), sqlParamPair.getRight());
    }

    public List<RowEntity> query(StatementBuilder statementBuilder) {
        Pair<String, Map<String, Object>> sqlParamPair = SqlGenerator.genSelectSql(new GenSqlParams(this.dbName, this.tableName, statementBuilder.getFields()));
        return new JdbcService().query(sqlParamPair.getLeft(), sqlParamPair.getRight());
    }
}
