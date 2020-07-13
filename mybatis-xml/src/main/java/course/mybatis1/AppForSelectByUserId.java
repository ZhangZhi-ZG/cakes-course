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
public class AppForSelectByUserId {

    public static void main(String[] args) throws IOException {

//        InputStream ins = Resources.getResource(MyBatisConst.CONFIG_FILE_NAME).openStream();
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ins);
//        SqlSession session = factory.openSession(true);
//        TbUserMapper tbUserMapper = session.getMapper(TbUserMapper.class);
//        List<TbUser> users = tbUserMapper.selectByUserId("1000001");
//        users.forEach(u -> System.out.println("u = " + u));


        //1. 获取mybatis总配置文件
        InputStream ins = Resources.getResource(MyBatisConst.CONFIG_FILE_NAME).openStream();
        //2. 创建factory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ins);
        SqlSession session = factory.openSession(true);
        //3. 获取mapper
        TbUserMapper tbUserMapper = session.getMapper(TbUserMapper.class);
        //4. 进行相关的数据库增删改查操作
        List<TbUser> users = tbUserMapper.selectByUserId("1000001");
        users.forEach(u -> System.out.println("u = " + u));
        //5. 关闭session资源
        session.close();
    }
}
