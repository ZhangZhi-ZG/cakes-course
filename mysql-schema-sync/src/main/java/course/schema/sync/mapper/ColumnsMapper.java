package course.schema.sync.mapper;

import course.schema.sync.model.ColumnsDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public interface ColumnsMapper extends BaseMapper {

    @Select("SELECT `table_schema`,`table_name`,`column_name`,`column_type`,`data_type`,`column_default`,`is_nullable` FROM `information_schema`.`columns`")
    Set<ColumnsDO> selectAll();

    @Select("SELECT `table_schema`,`table_name`,`column_name`,`column_type`,`data_type`,`column_default`,`is_nullable`,`column_comment` FROM `information_schema`.`columns` WHERE `table_schema` = #{tableSchema} AND `table_name` = #{tableName}")
    Set<ColumnsDO> selectByTable(@Param("tableSchema") String tableSchema, @Param("tableName") String tableName);
}
