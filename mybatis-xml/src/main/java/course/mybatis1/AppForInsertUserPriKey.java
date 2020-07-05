package course.mybatis1;

import com.google.common.io.Resources;
import course.mybatis1.bean.TbUser;
import course.mybatis1.mapper.TbUserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class AppForInsertUserPriKey {

    public static void main(String[] args) throws IOException {
        InputStream ins = Resources.getResource(MyBatisConst.CONFIG_FILE_NAME).openStream();
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ins);
        SqlSession session = factory.openSession(true);
        TbUserMapper tbUserMapper = session.getMapper(TbUserMapper.class);

        TbUser tbUser = new TbUser("3000003", "jim");
        System.out.println("before insert tbUser = " + tbUser);
        int rows = tbUserMapper.insertTbUser(tbUser);
        System.out.println("after insert tbUser = " + tbUser);

        System.out.println("rows = " + rows);

        session.close();
    }
}
