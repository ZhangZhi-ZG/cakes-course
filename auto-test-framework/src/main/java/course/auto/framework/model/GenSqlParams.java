package course.auto.framework.model;

import java.util.List;

public class GenSqlParams {
    private String dbName;
    private String tableName;
    private List<StatementEntity> statements;

    public GenSqlParams(String dbName, String tableName, List<StatementEntity> statements) {
        this.dbName = dbName;
        this.tableName = tableName;
        this.statements = statements;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<StatementEntity> getStatements() {
        return statements;
    }

    public void setStatements(List<StatementEntity> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        return "GenSqlParams{" +
                "dbName='" + dbName + '\'' +
                ", tableName='" + tableName + '\'' +
                ", statements=" + statements +
                '}';
    }
}
