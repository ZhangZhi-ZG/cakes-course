package course.schema.sync.model;

import com.google.common.base.Objects;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public class SchemaDO {
    private String schemaName;
    private String defaultCharacterSetName;

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getDefaultCharacterSetName() {
        return defaultCharacterSetName;
    }

    public void setDefaultCharacterSetName(String defaultCharacterSetName) {
        this.defaultCharacterSetName = defaultCharacterSetName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchemaDO schemaDO = (SchemaDO) o;
        return Objects.equal(schemaName, schemaDO.schemaName) &&
                Objects.equal(defaultCharacterSetName, schemaDO.defaultCharacterSetName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(schemaName, defaultCharacterSetName);
    }

    @Override
    public String toString() {
        return "SchemaDO{" +
                "schemaName='" + schemaName + '\'' +
                ", defaultCharacterSetName='" + defaultCharacterSetName + '\'' +
                '}';
    }
}
