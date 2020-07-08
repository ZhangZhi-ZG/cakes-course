package course.mybatis2.mapper;

import course.mybatis2.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public interface UserMapper {

    @Select("select * from `user`")
    List<User> selectUsers();
}
