package course.boot.mybatis.test;

import course.boot.mybatis.bean.UserDO;
import course.boot.mybatis.mapper.TbUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserDO {

    @Resource
    private TbUserMapper mapper;

    @Test
    public void testSelectUsers() {
        List<UserDO> users = mapper.selectUsers();
        users.forEach(u -> System.out.println("u = " + u));
    }
}
