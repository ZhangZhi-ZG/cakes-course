package course.schema.sync.mapper;

import course.schema.sync.model.TablesDO;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public interface TablesMapper extends BaseMapper {

    @Select("SELECT `table_schema`,`table_name`,`engine` FROM `information_schema`.`tables`")
    Set<TablesDO> selectAll();

    @Select("SELECT `table_schema`,`table_name`,`engine` FROM `information_schema`.`tables` WHERE `table_schema`=#{tableSchema}")
    Set<TablesDO> selectByTableSchema(String tableSchema);
}
