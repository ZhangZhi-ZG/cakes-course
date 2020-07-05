package course.mybatis1;

import com.google.common.io.Resources;
import course.mybatis1.bean.TbUser;
import course.mybatis1.mapper.TbUserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class AppForSelectUser5 {

    public static void main(String[] args) throws IOException {
        InputStream ins = Resources.getResource(MyBatisConst.CONFIG_FILE_NAME).openStream();
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ins);
        SqlSession session = factory.openSession(true);
        TbUserMapper tbUserMapper = session.getMapper(TbUserMapper.class);

        List<TbUser> users = tbUserMapper.selectUser5("1000003", "zhangsan3");
        users.forEach(u -> System.out.println("u = " + u));

        session.close();
    }
}
