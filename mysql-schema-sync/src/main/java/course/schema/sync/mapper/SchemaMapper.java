package course.schema.sync.mapper;

import course.schema.sync.model.SchemaDO;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public interface SchemaMapper extends BaseMapper {

    @Select("SELECT `schema_name`,`default_character_set_name` FROM `information_schema`.`schemata`")
    Set<SchemaDO> selectAllSchema();

    @Select("SELECT schema_name,default_character_set_name FROM `information_schema`.`schemata` WHERE `schema_name`=#{schemaName}")
    Set<SchemaDO> selectSchemaByName(String schemaName);
}
