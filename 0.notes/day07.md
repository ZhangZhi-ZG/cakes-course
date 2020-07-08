# day07
> MyBatis,设计模式

---

## 今日大纲

#### MyBatis
* 概述
* 使用
* 配置
* 整合

#### 设计模式
* 责任链
* 装饰器
* 监听器

#### Gradle
* 配置

---

## MyBatis

#### MyBatis是什么
* MyBatis 是一款优秀的持久层框架，它支持自定义 SQL、存储过程以及高级映射。
* MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作
* MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。
* 以往听到的 SSM，其中的 M就是指的MyBatis,差不多是当前互联网公司中数据库持久层框架的首选

#### Hello World(Xml版)
* 测试SQL
```sql
CREATE DATABASE IF NOT EXISTS course DEFAULT CHARSET utf8mb4;

USE course;

SET NAMES utf8mb4;

-- tag信息表
CREATE TABLE IF NOT EXISTS `tb_user`
(
    `id`        BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `user_id`   VARCHAR(64)         NOT NULL DEFAULT '' COMMENT 'user id',
    `user_name` VARCHAR(128)        NOT NULL DEFAULT '' COMMENT '用户名称',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';

-- 测试数据
insert into tb_user(`user_id`,`user_name`) values ('1000001','zhangsan1'),
                                                  ('1000002','zhangsan2'),
                                                  ('1000003','zhangsan3');
```

* 引入依赖
```groovy
implementation('org.mybatis:mybatis:3.5.5')
implementation('mysql:mysql-connector-java:8.0.20')
```

* 添加mybatis总配置
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url"
                          value="jdbc:mysql://127.0.0.1:3306/course?useUnicode=true&amp;characterEncoding=utf-8&amp;useSSL=false&amp;serverTimezone=UTC"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <mapper resource="mappers/UserMapper.xml"/>
    </mappers>

</configuration>
```

* 实体bean
```java
public class User {
    private Long id;
    private String userId;
    private String userName;

    // setter & getter
}
```

* Mapper接口代码编写
```java
public interface UserMapper {

    List<User> selectByUserId(String userId);
}
```

* 在resources目录下添加mappers/Mapper.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="course.mybatis1.mapper.UserMapper">

    <select id="selectByUserId" resultType="course.mybatis1.bean.User">
        select * from `tb_user` where `user_id` = #{userId}
    </select>
</mapper>
```

* 测试类
```java
public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectByUserId("1000001");
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }
```

#### Hello World(注解版)
* 修改Xml版中mybatis 配置文件 mybatis-config.xml
```xml
<mappers>
    <mapper class="course.mybatis1.mapper.UserMapper"/>
</mappers>
```

* 移除UserMapper.xml文件
* 修改UserMapper类
```java
@Mapper
public interface UserMapper {
    @Select("select * from `tb_user` where `user_id`=#{userId}")
    List<User> selectByUserId(String userId);
}

```

#### Hello World之CRUD
* insert
* update
* delete

#### 总配置详解
* settings
* typeAliases
* environments
* mappers
* properties

#### Mapper配置文件配置详解
* select
* insert
* update
* delete
* parameterType="xxx" 
* parameterMap="xxx" 
* resultType="xxx"
* resultMap="xxx"
* 参考: https://mybatis.org/mybatis-3/zh/sqlmap-xml.html

#### 动态SQL
* if结构, xml版 userId+userName
```xml
<select id="selectUsers" resultType="User">
    select * from `tb_user` where 1=1
    <if test="userId != null">
        AND `user_id` = #{userId}
    </if>

    <if test="userName != null">
        AND `user_name` = #{userName}
    </if>
</select>
```

* if结构, 注解版 userId+userName
```java
@Select({
        "    <script>" +
                "        select * from `tb_user` where 1=1" +
                "        <if test='userId != null'>" +
                "            AND `user_id` = #{userId}" +
                "        </if>" +
                "        <if test='userName != null'>" +
                "            AND `user_name` = #{userName}" +
                "        </if>" +
                "   </script>"
})
List<User> selectUsers(User user);
```

* 参考: https://mybatis.org/mybatis-3/zh/dynamic-sql.html

#### 其他:获取插入数据的主键
* useGeneratedKeys="true" 标识字段即使用生成的key
* keyProperty="id", 指定主键的属性对应的列
* xml版配置
```xml
<insert id="insertUser" useGeneratedKeys="true" keyProperty="id">
    insert into `tb_user`(`user_id`,`user_name`) values (#{userId},#{userName})
</insert>
```
* 注解版配置
```java
@Insert("insert into `tb_user`(`user_id`,`user_name`) values (#{userId},#{userName})")
@Options(useGeneratedKeys = true, keyProperty = "id")
Integer insertUser(User user);
```

#### 其他:批量插入+获取主键
* xml版
```xml
<insert id="insertUsers" useGeneratedKeys="true" keyProperty="id">
    insert into `tb_user`(`user_id`,`user_name`) values
    <foreach item="item" collection="list" separator=",">
        (#{item.userId}, #{item.userName})
    </foreach>
</insert>
```

* 注解版
```java
@Insert({
        "<script>",
        "insert into `tb_user`(`user_id`,`user_name`) values ",
        "<foreach collection='users' item='item' separator=','>",
        "(#{item.userId}, #{item.userName})",
        "</foreach>",
        "</script>"
})
int insertUsers(@Param("users") List<User> users);

```


#### 与SpringBoot整合
* 测试sql
* 依赖添加
```groovy
implementation('org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.3')
implementation('mysql:mysql-connector-java:8.0.20')
```

* application.yml配置
```yml
server:
  port: 8009
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/course?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8
    username: root
    password: 123456
mybatis:
  configuration:
    #    @Bean  
    #    public ConfigurationCustomizer configurationCustomizer() {  
    #        return new ConfigurationCustomizer() {  
    #  
    #            @Override  
    #            public void customize(org.apache.ibatis.session.Configuration configuration) {  
    #                configuration.setMapUnderscoreToCamelCase(true);
    #            }  
    #        };  
    #    }
    map-underscore-to-camel-case: true

```

* 编写主启动类
```java
/**
 * author: xiha
 * crate time: 2020/6/24
 */
@SpringBootApplication
@MapperScan("course.boot.mybatis.mapper")
public class BootMyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootMyBatisApplication.class, args);
    }
}
```

* 编写实体bean与mapper
```java
public class User {
    private Long id;
    private String userId;
    private String userName;

    // getter & setter
}
```

```java
@Mapper
public interface UserMapper {

    @Select("select * from `tb_user` where `user_id` = #{userId}")
    List<User> selectByUserId(String userId);

}
```

* 测试类
```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserMapper {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectById(){
        List<User> users = userMapper.selectByUserId("1000001");
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }
}

```

---

## 设计模式

#### 责任链设计模式
* 场景设定: 数据处理，根据不同的文件类型选择不同的处理方式
    - 比如 文件类型有 mp4,avi,png,jpg 对应的也会有不同的文件类型的解析器
    - 文件类型可不一定只有这几种，随着业务的扩展会不断增加， 比如 : txt, rmvb

#### 策略设计模式
* 复用责任链的使用场景

#### 装饰器设计模式
* 场景设定: 字符串处理。策略字符串处理。
    - randomId ==> 123455223123
    - randomStr ===> asdjhskdhiwe
    - 给定一个字符串，从中做解析，如果有对应的策略标识符，就按照策略生成对应的字符串

#### 监听器设计模式
* 场景设定: 航空公司会出票。去哪儿网，携程，马蜂窝各个公司会抢票。并会对此票做一系列的处理
    - 

---

## gradle
#### gradle是什么?
* 构建工具,maven之后的一款新兴工具

#### 我为什么选择gradle?
* 第一眼就一切都对了
* 清爽，干净，跟我的风格完全匹配

#### gradle文件初见, cakes-course/build.gradle
```groovy
allprojects { // 整体工程配置
    group 'course'  // jar包管理的group name,与maven一致, maven中的artifactId就是本项目的名字
    version '1.0.0-SNAPSHOT' // 与maven的version一致
    buildDir = 'target' // 构建后的包名

    apply plugin: 'idea'  // 引入插件
    apply plugin: 'maven' // 引入插件
}

subprojects {  // 子工程配置项
    apply plugin: 'java' // 引入插件,不要放到allprojects作用域里，否则每次刷新时会自建src目录,烦人

    sourceCompatibility = 1.8 // 编码变异的jdk版本指定为1.8
    targetCompatibility = 1.8 // 目标版本 jdk版本指定为1.8

    repositories { // 仓库引用配置
        mavenLocal() // 先加载本地maven仓库
        maven { url 'http://maven.aliyun.com/nexus/content/groups/public/' }  // 自定义要下载jar包地址
        mavenCentral() // 从maven中央仓库获取
    }

    ext { // 自定义参数
        springBootVersion = '2.2.2.RELEASE'
        guavaVersion = '29.0-jre'
    }

    idea { // idea插件配置
        module { // 模块 配置
            downloadSources = true  // 下载源码?
            downloadJavadoc = false // 下载java文档?
            sourceDirs += file('src/main/resources') // 资源目录
        }
    }

    configurations { // 配置节点

    }

    dependencies { // 依赖添加节点,各种jar包的引入就是在此配置
        compile("com.google.guava:guava:$guavaVersion")
    }
}

```

#### gradle特性
* Gradle 的核心在于基于 Groovy 的丰富而可扩展的域描述语言(DSL)
* Groovy 通过声明性的语言元素将基于声明的构建推向下层，你可以按你想要的方式进行组合
* Gradle 允许你在构建执行的整个生命周期，对它的核心配置及执行行为进行监视并自定义。
* Gradle有非常良好的扩展性，从简单的单项目构建，到庞大的多项目构建，它都能显著地提升你的效率
* Gradle 对多项目构建的支持非常出色
* 从 Maven 和 Ivy 的远程仓库的传递依赖管理，到本地文件系统的 jar 包或目录，Gradle 对所有的管理策略都提供了方便的支持
* Gradle 的构建脚本是采用 Groovy 写的,而不是用 XML,但与其他方法不同,它并不只是展示了由一种动态语言编写的原始脚本的强大. 那样将导致维护构建变得很困难.Gradle的整体设计是面向被作为一门语言，而不是一个僵化的框架.并且Groovy是我们允许你通过抽象的 Gradle 描述你个人的 story 的黏合剂
* Gradle Wrapper 允许你在没有安装 Gradle 的机器上执行 Gradle 构建.

#### gradle元素
* projects
    + 任何一个Gradle构建都是由一个或多个projects组成
    + 每个project包括许多可构建组成部分
    + 
* tasks
    + 每个project由多个 tasks 组成
    + 每个 task 都代表了构建执行过程中的一个原子性操作
    + 如编译，打包，生成 javadoc，发布到某个仓库等操作
#### gradle常用任务
* clean: 删除 build 目录以及所有构建完成的文件
* assemble: 编译并打包 jar 文件，但不会执行单元测试
* check: 编译并测试代码

#### 常用打包配置
* 编译jar包
```groovy
jar {
    manifest {
        attributes(
            'Implementation-Title': 'Gradle Quickstart', 'Implementation-Version': version,
            'Main-Class': 'xxx.xxx.Xxx'
    }
}
```

* 发布jar包, 执行 任务: uploadArchives 
```groovy
uploadArchives {
    repositories {
       flatDir {
           dirs 'repos'
       }
    }
}
```

* 发布到maven仓库
```groovy
apply plugin: 'maven'
uploadArchives {
    repositories {
        mavenDeployer {
            repository(url: "http://xxxx.xxx.com/libs-snapshot/")
        }
    }
}
```

#### 编译作用域
* compile: 编译范围依赖在所有的 classpath 中可用，同时它们也会被打包
* runtime: runtime 依赖在运行和测试系统的时候需要，但在编译的时候不需要
* testCompile: 测试期编译需要的附加依赖
* testRuntime: 测试运行期需要

#### 仓库配置
```groovy
repositories {
    maven { url 'http://maven.aliyun.com/nexus/content/groups/public/' }
    ivy { url "http://repo.xxxx.com/repo" }
}    
```

---

## 总结
* 重点: MyBatis/设计模式

---

## 学习资料
[MyBatis官方文档](https://mybatis.org/mybatis-3/zh/index.html)

[MyBatis技术内幕](https://book.douban.com/subject/27087564/)

---

## 作业

#### 作业1 用动态代理自行实现Mapper class对数据库的操作