package course.schema.sync.factory;

import course.schema.sync.model.ConnectInfo;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public final class LocalSqlSessionFactory {

    private LocalSqlSessionFactory() {

    }

    private static final class ClassHolder {
        private static final LocalSqlSessionFactory INSTANCE = new LocalSqlSessionFactory();
    }

    public static LocalSqlSessionFactory of() {
        return ClassHolder.INSTANCE;
    }

    public SqlSession getSqlSession(ConnectInfo connectInfo) {
        Configuration configuration = new Configuration();

        // <settings>
        //        <setting name="mapUnderscoreToCamelCase" value="true"/>
        //    </settings>
        configuration.setMapUnderscoreToCamelCase(true);

        // <environments default="development">
        //        <!-- 可以有多个环境的配置，每个配置用id区分，使用时可以在此修改，或者代码中来指定 -->
        //        <environment id="development">
        //            <transactionManager type="JDBC"/>
        //            <dataSource type="POOLED">
        //                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
        //                <property name="url" value="${url}"/>
        //                <property name="username" value="root"/>
        //                <property name="password" value="123456"/>
        //            </dataSource>
        //        </environment>
        Environment environment = new Environment.Builder("common")
                .dataSource(LocalDataSourceFactory.of().getDataSource(connectInfo))
                .transactionFactory(new JdbcTransactionFactory())
                .build();
        configuration.setEnvironment(environment);


        // <mappers>
        //        <!-- 一般配置文件使用的方式 -->
        //        <mapper resource="mappers/TbUserMapper.xml"/>
        //        <!--        <package name="course.mybatis1.mapper"/>-->
        //    </mappers>
        configuration.addMappers("course.schema.sync.mapper");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        return sessionFactory.openSession(true);
    }

}
