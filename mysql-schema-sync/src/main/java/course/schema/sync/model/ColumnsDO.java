package course.schema.sync.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public class ColumnsDO {
    private String tableSchema;
    private String tableName;
    private String columnName;
    private String columnType;
    private String dataType;
    private String columnDefault;
    private String isNullable;
    private String columnComment;
    private boolean isAdd;

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

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public boolean isAdd() {
        return isAdd;
    }

    public void setAdd(boolean add) {
        isAdd = add;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnsDO columnsDO = (ColumnsDO) o;
        return Objects.equal(tableSchema, columnsDO.tableSchema) &&
                Objects.equal(tableName, columnsDO.tableName) &&
                Objects.equal(columnName, columnsDO.columnName) &&
                Objects.equal(columnType, columnsDO.columnType) &&
                Objects.equal(dataType, columnsDO.dataType) &&
                Objects.equal(columnDefault, columnsDO.columnDefault) &&
                Objects.equal(isNullable, columnsDO.isNullable) &&
                Objects.equal(columnComment, columnsDO.columnComment);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tableSchema, tableName, columnName, columnType, dataType, columnDefault, isNullable, columnComment);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("tableSchema", tableSchema)
                .add("tableName", tableName)
                .add("columnName", columnName)
                .add("columnType", columnType)
                .add("dataType", dataType)
                .add("columnDefault", columnDefault)
                .add("isNullable", isNullable)
                .add("columnComment", columnComment)
                .add("isAdd", isAdd)
                .toString();
    }
}
