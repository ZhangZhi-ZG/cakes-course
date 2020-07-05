package course.mybatis1.mapper;

import course.mybatis1.bean.TbUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public interface TbUserMapper {

    List<TbUser> selectByUserId(String userId);

    List<TbUser> selectUser(TbUser user);

    List<TbUser> selectUser2(String userId, String userName);

    List<TbUser> selectUser3(@Param("userId") String userId, @Param("userName") String userName);

    List<TbUser> selectUser4(@Param("userId") String userId, @Param("userName") String userName);

    List<TbUser> selectUser5(@Param("userId") String userId, @Param("userName") String userName);

    int insertUser(TbUser user);

    List<TbUser> selectUserForDynamic(TbUser user);

    int insertTbUser(TbUser user);

    int insertUsers(List<TbUser> users);
}
