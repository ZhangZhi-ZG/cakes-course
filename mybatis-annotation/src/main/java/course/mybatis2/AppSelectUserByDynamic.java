package course.mybatis2;

import com.google.common.io.Resources;
import course.mybatis2.bean.TbUser;
import course.mybatis2.mapper.TbUserMapper;
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
public class AppSelectUserByDynamic {

    public static void main(String[] args) throws IOException {
        InputStream ins = Resources.getResource(MyBatisConst.CONFIG_FILE_NAME).openStream();
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ins);
        SqlSession session = factory.openSession(true);
        TbUserMapper tbUserMapper = session.getMapper(TbUserMapper.class);


//        List<TbUser> users = tbUserMapper.selectByDynamic(new TbUser("1000003", "zhangsan3"));
//        List<TbUser> users = tbUserMapper.selectByDynamic(new TbUser("1000003", null));
//        List<TbUser> users = tbUserMapper.selectByDynamic(new TbUser(null, "zhangsan1"));
        List<TbUser> users = tbUserMapper.selectByDynamic(new TbUser(null, null));
        users.forEach(u -> System.out.println("u = " + u));

        session.close();
    }
}
