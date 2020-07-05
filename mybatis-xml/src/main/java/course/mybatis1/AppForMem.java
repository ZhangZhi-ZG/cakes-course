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
public class AppForMem {
    public static void main(String[] args) throws IOException {
        InputStream ins = Resources.getResource(MyBatisConst.CONFIG_FILE_NAME).openStream();
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ins);
        SqlSession session = factory.openSession();
        TbUserMapper mapper = session.getMapper(TbUserMapper.class);
        List<TbUser> tbUsers = mapper.selectByUserId("1000");
    }
}
