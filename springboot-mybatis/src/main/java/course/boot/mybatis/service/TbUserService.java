package course.boot.mybatis.service;

import course.boot.mybatis.bean.UserDO;
import course.boot.mybatis.bean.UserDTO;

import java.util.List;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public interface TbUserService {

    List<UserDTO> selectUsers();
}
