package course.boot.mybatis.service.impl;

import course.boot.mybatis.bean.UserDO;
import course.boot.mybatis.bean.UserDTO;
import course.boot.mybatis.mapper.TbUserMapper;
import course.boot.mybatis.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserMapper mapper;

    @Override
    public List<UserDTO> selectUsers() {
        List<UserDO> users = mapper.selectUsers();
        return users.stream()
                .map(userDO -> new UserDTO(userDO.getUserId(), userDO.getUserName()))
                .collect(Collectors.toList());
    }
}
