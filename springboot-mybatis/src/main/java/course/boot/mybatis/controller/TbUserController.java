package course.boot.mybatis.controller;

import course.boot.mybatis.bean.UserDO;
import course.boot.mybatis.bean.UserDTO;
import course.boot.mybatis.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
@RestController
public class TbUserController {

    @Autowired
    private TbUserService userService;

    @RequestMapping("/selectUsers")
    public List<UserDTO> selectAll() {
        return userService.selectUsers();
    }
}
