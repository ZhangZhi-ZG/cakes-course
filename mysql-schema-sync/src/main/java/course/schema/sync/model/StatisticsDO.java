package course.schema.sync.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public class StatisticsDO {
    private String tableSchema;
    private String tableName;
    private String indexName;
    private Integer seqInIndex;
    private String columnName;
    private Integer nonUnique;

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

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public Integer getSeqInIndex() {
        return seqInIndex;
    }

    public void setSeqInIndex(Integer seqInIndex) {
        this.seqInIndex = seqInIndex;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getNonUnique() {
        return nonUnique;
    }

    public void setNonUnique(Integer nonUnique) {
        this.nonUnique = nonUnique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsDO that = (StatisticsDO) o;
        return Objects.equal(tableSchema, that.tableSchema) &&
                Objects.equal(tableName, that.tableName) &&
                Objects.equal(indexName, that.indexName) &&
                Objects.equal(seqInIndex, that.seqInIndex) &&
                Objects.equal(columnName, that.columnName) &&
                Objects.equal(nonUnique, that.nonUnique);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tableSchema, tableName, indexName, seqInIndex, columnName, nonUnique);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("tableSchema", tableSchema)
                .add("tableName", tableName)
                .add("indexName", indexName)
                .add("seqInIndex", seqInIndex)
                .add("columnName", columnName)
                .add("nonUnique", nonUnique)
                .toString();
    }
}
