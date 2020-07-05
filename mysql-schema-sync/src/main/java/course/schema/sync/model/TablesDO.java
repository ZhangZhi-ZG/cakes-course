package course.schema.sync.model;

import com.google.common.base.Objects;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public class TablesDO {
    private String tableSchema;
    private String tableName;
    private String engine;

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TablesDO tablesDO = (TablesDO) o;
        return Objects.equal(tableSchema, tablesDO.tableSchema) &&
                Objects.equal(tableName, tablesDO.tableName) &&
                Objects.equal(engine, tablesDO.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tableSchema, tableName, engine);
    }

    @Override
    public String toString() {
        return "TablesDO{" +
                "tableSchema='" + tableSchema + '\'' +
                ", tableName='" + tableName + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }
}
