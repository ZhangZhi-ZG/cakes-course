package course.schema.sync.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

/**
 * author: heiha
 */
public class IndexModel {
    private String indexName;
    private String tableSchema;
    private String tableName;
    private Integer nonUnique;
    private List<String> columns;

    public static Builder builder() {
        return new Builder();
    }

    public IndexModel() {
    }

    private IndexModel(Builder builder) {
        this.indexName = builder.indexName;
        this.tableSchema = builder.tableSchema;
        this.tableName = builder.tableName;
        this.columns = builder.columns;
        this.nonUnique = builder.nonUnique;
    }

    public static class Builder {
        private String indexName;
        private String tableSchema;
        private String tableName;
        private Integer nonUnique;
        private List<String> columns;

        public Builder nonUnique(Integer nonUnique) {
            this.nonUnique = nonUnique;
            return this;
        }

        public Builder indexName(String indexName) {
            this.indexName = indexName;
            return this;
        }

        public Builder tableSchema(String tableSchema) {
            this.tableSchema = tableSchema;
            return this;
        }

        public Builder tableName(String tableName) {
            this.tableName = tableName;
            return this;
        }

        public Builder columns(List<String> columns) {
            this.columns = columns;
            return this;
        }

        public IndexModel build() {
            return new IndexModel(this);
        }
    }

    public String getIndexName() {
        return indexName;
    }

    public String getTableSchema() {
        return tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public Integer getNonUnique() {
        return nonUnique;
    }

    public List<String> getColumns() {
        return columns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndexModel that = (IndexModel) o;
        return Objects.equal(indexName, that.indexName) &&
                Objects.equal(columns, that.columns);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(indexName, columns);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("indexName", indexName)
                .add("tableSchema", tableSchema)
                .add("tableName", tableName)
                .add("columns", columns)
                .toString();
    }
}
