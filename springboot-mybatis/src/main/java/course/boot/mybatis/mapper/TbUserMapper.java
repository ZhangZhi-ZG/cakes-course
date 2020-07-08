package course.boot.mybatis.mapper;

import course.boot.mybatis.bean.UserDO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
@Repository
public interface TbUserMapper {

    @Select("select * from `tb_user`")
    List<UserDO> selectUsers();
}
