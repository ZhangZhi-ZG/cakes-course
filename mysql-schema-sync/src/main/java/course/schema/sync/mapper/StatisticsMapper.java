package course.schema.sync.mapper;

import course.schema.sync.model.StatisticsDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public interface StatisticsMapper extends BaseMapper {

    @Select("SELECT `table_schema`,`table_name`,`index_name`,`seq_in_index`,`column_name`,`non_unique` FROM `information_schema`.`statistics` WHERE `table_schema`=#{tableSchema} AND `table_name`=#{tableName}")
    Set<StatisticsDO> selectByTable(@Param("tableSchema") String tableSchema, @Param("tableName") String tableName);
}
