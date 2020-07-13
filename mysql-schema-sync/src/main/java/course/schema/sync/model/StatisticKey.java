package course.schema.sync.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.Builder;
import lombok.Data;

/**
 * author: heiha
 */
public class StatisticKey {

    private String indexName;
    private Integer nonUnique;

    private String tableSchema;
    private String tableName;

    private StatisticKey(Builder builder) {
        this.indexName = builder.indexName;
        this.nonUnique = builder.nonUnique;
        this.tableSchema = builder.tableSchema;
        this.tableName = builder.tableName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String indexName;
        private Integer nonUnique;

        private String tableSchema;
        private String tableName;

        public Builder indexName(String indexName) {
            this.indexName = indexName;
            return this;
        }

        public Builder nonUnique(Integer nonUnique) {
            this.nonUnique = nonUnique;
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

        public StatisticKey build() {
            return new StatisticKey(this);
        }
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public Integer getNonUnique() {
        return nonUnique;
    }

    public void setNonUnique(Integer nonUnique) {
        this.nonUnique = nonUnique;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticKey that = (StatisticKey) o;
        return Objects.equal(indexName, that.indexName) &&
                Objects.equal(nonUnique, that.nonUnique);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(indexName, nonUnique);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("indexName", indexName)
                .add("nonUnique", nonUnique)
                .toString();
    }
}
