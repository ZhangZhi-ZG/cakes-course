# day06
> SpringBoot

## 今日大纲

#### SpringBoot
* 重点

#### Git

#### Gradle

---

## SpringBoot

#### SpringBoot给我们带来了什么？
* 未来

#### SpringBoot给我个人带来了什么？
* 决定了我在Java这条路上走下去的决心

#### SpringBoot环境搭建
* 依赖配置(gradle)
```groovy
buildDir = 'target'

// 添加两个 SpringBoot的插件
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'

buildscript {
    ext {
        // 配置 SpringBoot版本为 2.2.2.RELEASE
        springBootVersion = '2.2.2.RELEASE'
    }
    repositories {
        maven {
            url 'https://plugins.gradle.org/m2/'
        }
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}

sourceSets.main.resources {
    if (project.hasProperty('profile')) {
        srcDir 'src/main/resources-' + project.profile
        srcDir 'src/test/resources-' + project.profile
    } else {
        srcDir 'src/main/resources-test'
        srcDir 'src/test/resources-test'
    }
}

clean.doLast {
    delete projectDir.path + '/target'
}

configurations {
}

dependencies {
    // 最关键的导入, 导入 SpringBoot web starter 启动器
    implementation('org.springframework.boot:spring-boot-starter-web')
}

```

* 在resources目录下添加配置文件application.yml(非必须,不加用默认的)
```yml
server:
  port: 8080
```

* 填写主启动类
```java
// 关键注解，表示当前类是工程的启动类且会基于此类找到包,作为扫描的根
@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        // 运行的主要类,将启动类作为第一个参数,后面跟着启动参数
        SpringApplication.run(BootApplication.class, args);
    }
}
```
* 添加测试控制器
```java
@RestController
public class PingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PingController.class);

    @RequestMapping("/ping")
    public String ping() {
        LOGGER.info("ping start.");
        return "pong";
    }
}
```

* 测试: http://127.0.0.1:8080/ping


#### 老生常谈之MVC
* @Controller
    - 拦截器，过滤器的处理(安全，登陆。。。)
    - 参数校验（通用的参数校验，与业务关联不大）
        + amount（金额） ===》 金额大于0
        + orderId 通用校验，除了非空之外， 那么所有业务都需要长度必须为32位， 可以放在controller层来做处理。
        + 业务层校验，比如支付限制最小支付金额必须大于10块。  --> 放到业务层去处理
    - access log, cost time
    - 处理service代码时，在controller来做统一的异常处理
    - 做统一的流量收集。
    - 做统计，PV，UV
* @Service
    - 真正的处理业务逻辑，
    - 完成我们业务需求的绝大多数的能力都在这里做的。
    - 要做好业务异常的处理（订单状态不对，订单不存在，支付金额不足）
    - 做好业务拆分和设计，将各自的能力界定好边界。
    - 调外部服务。。。=> 支付宝|微信 ，
* @Repository
    - 简单： 数据库的增改查。没有删除

#### SpringBoot参数接受
* @RequestParam
* @PathVariable
* @RequestBody & @ResponseBody

#### SpringBoot各种配置
* yml语法
    - list
    - string
    - bean
* 启动日志
```log
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.2.RELEASE)

2020-06-21 13:51:19.486  WARN 26342 --- [           main] o.s.boot.StartupInfoLogger               : InetAddress.getLocalHost().getHostName() took 5006 milliseconds to respond. Please verify your network configuration (macOS machines may need to add entries to /etc/hosts).
2020-06-21 13:51:24.499  INFO 26342 --- [           main] course.boot.examples.ExampleApplication  : Starting ExampleApplication on haocdeMacBook-Pro.local with PID 26342 ()  // 启动后的进程id
2020-06-21 13:51:24.501  INFO 26342 --- [           main] course.boot.examples.ExampleApplication  : No active profile set, falling back to default profiles: default  // 当前启动的profile
2020-06-21 13:51:25.121  INFO 26342 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)  // 启动进程的端口号
2020-06-21 13:51:25.127  INFO 26342 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-06-21 13:51:25.127  INFO 26342 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.29]
2020-06-21 13:51:25.186  INFO 26342 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-06-21 13:51:25.186  INFO 26342 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 654 ms
2020-06-21 13:51:25.304  INFO 26342 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-21 13:51:25.427  INFO 26342 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path '' // 启动服务器之后的 根路径
2020-06-21 13:51:25.430  INFO 26342 --- [           main] course.boot.examples.ExampleApplication  : Started ExampleApplication in 16.167 seconds (JVM running for 21.626)

```
* 配置项获取
    - @Value
    - @ConfigurationProperties // 注: 需在加一个@Component来标识让Spring识别
    - 区别: 
        + 若只是个别的属性导入可以使用@value来指定
        + 若是要导入一个实体配置项则使用@ConfigurationProperties更加简单
    - @PropertySource
        + 用于读取指定的properties配置文件
        + ConfigurationProperties默认从application.yml中直接读取。文件会变得很臃肿
        + 可以配合PropertySource将配置项迁移至单独的配置文件中
        + 例:
            * @PropertySource(value = "classpath:db.properties")
            * @ConfigurationProperties(prefix = "db")
    - @ImportResource
        + 读取外部配置文件，一般用于将配置文件进行拆分后做的统一导入
        + 一般在主启动类或配置类上添加即可
        + 如: @ImportResource(locations = "classpath:xxx.xml")
* active profile 配置
    - No active profile set, falling back to default profiles: default
    - 一般用于多套环境支持。如: application-dev.yml,application-test.yml
    - 指定profile启动
        + java -jar target/libs/springboot-1.0.0-SNAPSHOT.jar --spring.profiles.active=dev

#### SpringBoot常见web配置: Servlet
* 自己实现HttpServlet类，并覆写方法 doGet或doPost
* 将此类标识成@WebServlet, 名字随意起
* 在启动类上添加包扫描路径即可，@ServletComponentScan
* Servlet示例:
```java
@WebServlet(name = "basicServlet")
public class BasicServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        Map<String, String> parameterMap = handleParamMap(req.getParameterMap());
        LOGGER.info("basic servlet start for uri={}, params={}", requestURI, parameterMap);
        if (requestURI.equals("/examples/ping1111")) {
            resp.setStatus(200);
            ServletOutputStream outputStream = resp.getOutputStream();
            outputStream.write("hahahahah".getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }

    private Map<String, String> handleParamMap(Map<String, String[]> parameterMap) {
        return parameterMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, param -> param.getValue()[0]));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

#### SpringBoot常见web配置:拦截器(已登录场景为例)
* 1.实现HandlerInterceptor接口完成自己的拦截器业务编写
* 2.在配置类实现接口WebMvcConfigurer,在addInterceptors方法中添加自己的拦截器
* 注: 要么自己new HandlerInterceptor，或者标识成@Component让SpringBoot来注入
* 思考下:如果给特定的方法加上拦截器处理?

#### SpringBoot常见web配置:过滤器
* 配置方式:
    - 方式一: 使用@WebFilter
        + 创建过滤器,实现接口Filter
        + 标识注解: @WebFilter(filterName = "xxxFilter", urlPatterns = "/**")
        + 实现doFilter方法
        + 在配置类中添加注解: @ServletComponentScan,basePackages指定包路径
    - 方式二: 使用@Bean
        + 在@Configuration类手动配置过滤器
        + @Bean标识 FilterRegistrationBean
* 使用场景:

#### SpringBoot单侧
* 加入依赖: 
    - testImplementation('org.springframework.boot:spring-boot-starter-test')
* @SpringBootTest
* @RunWith(SpringRunner.class)

#### SpringBoot定时任务
* 配置启动标识: @EnableScheduling
* 配置调度类: @Component + @Scheduled(cron = "*/5 * * * * *")

#### SpringBoot JDBC
* 导入依赖
```groovy
implementation('org.springframework.boot:spring-boot-starter-jdbc')
implementation('mysql:mysql-connector-java:8.0.20')
```

* 在application.yml中配置数据源连接
```yml
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/course
    username: root
    password: 123456
    driver-class-name: com.mysql.cj.jdbc.Driver
```

* 数据库操作模板使用: JdbcTemplate

#### SpringBoot整合框架？？？
* MyBatis

---

## 常用工具
#### git
* git是啥？
    - 

* git相关概念
    - 工作目录: 持有实际文件
    - 暂存区（Index）: 缓存区域，临时保存改动
    - HEAD: 指向最后一次提交的结果
        ![git工作流程](../0.imgs/git-tree.png)

* git常用命令操作
    - 创建新仓库
        + 创建新文件夹，打开，然后执行>git init
    - 检出仓库
        + 克隆本地仓库: git clone /path/to/repository
        + 克隆远程仓库: git clone username@host:/path/to/repository
    - 添加至暂存区
        + git add <filename>
        + git add *
        + git add .
    - 提交
        + git commit -m "代码提交信息"
            * 改动已经提交到了 HEAD，但还没到远端仓库
    - 推送
        + git push origin master
            * master是分支名，其他分支换名即可
        + git remote add origin <server-path>
            * 若本地没有克隆现有仓库，此时想将仓库连接到某个远程服务器时可如此操作
* 分支特性
    - 分支是用来将特性开发绝缘开来的
    - 在创建仓库的时候，master 是“默认的”分支
    - 在其他分支上进行开发，完成后再将它们合并到主分支上
* 分支模式
    ![](../0.imgs/branch-module.png)
* 分支操作
    - 创建一个叫做“feature_x”的分支，并切换
        + git checkout -b feature_x
    - 切换回master分支
        + git checkout master
    - 删除分支
        + git branch -d feature_x
    - 将本地分支推动至远端
        + git push origin <branch>
* 更新&合并
    - 更新本地仓库至最新
        + git pull
    - 合并其他分支至自己分支
        + git merge <branch>
* 冲突
    - 合并时并不总是一帆风顺的，如果修改相同的数据，此时就需要进行手动解决冲突
    - 修改后添加文件. >git add <filename>
    - 合并之前可以diff查看
        + git diff <source_branch> <target_branch>
* 标签
    - 为指定提交添加标签
        + git tag 1.0.0 88cb7f51e1
        + 其中88cb7f51e1是标记的提交 ID 的前 10 位字符，课基于 git log来获取
        + 相当于是给提交起名
* 日志
    - 查看本地仓库的历史记录
        + git log
    - 只看某一个人的提交记录
        + git log --author=jim
    - 压缩每一条提交记录只占一行输出
        + git log --pretty=oneline
    - 通过 ASCII 艺术的树形结构来展示所有的分支,名字+标签
        + git log --graph --oneline --decorate --all
    - 看看哪些文件改变了
        + git log --name-status
* 恢复
    - 操作失误时替换掉本地改动
        + git checkout -- <filename>
        + 此命令会使用 HEAD 中的最新内容替换掉你的工作目录中的文件
    - 改动本地所有文件恢复至 HEAD
        + git fetch origin
        + git reset --hard origin/master
            * master可以指定远程存在的其他分支

* git常用配置
    - 配置提交人+邮件
        + git config --global user.name "abc"   
        + git config --global user.email "abc@123.com" 

#### gradle
* gradle是什么?
    - 构建工具,maven之后的一款新兴工具
* 我为什么选择gradle?
    - 第一眼就一切都对了
    - 清爽，干净，跟我的风格完全匹配
* gradle文件初见, cakes-course/build.gradle
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

* gradle特性
    - Gradle 的核心在于基于 Groovy 的丰富而可扩展的域描述语言(DSL)
    - Groovy 通过声明性的语言元素将基于声明的构建推向下层，你可以按你想要的方式进行组合
    - Gradle 允许你在构建执行的整个生命周期，对它的核心配置及执行行为进行监视并自定义。
    - Gradle有非常良好的扩展性，从简单的单项目构建，到庞大的多项目构建，它都能显著地提升你的效率
    - Gradle 对多项目构建的支持非常出色
    - 从 Maven 和 Ivy 的远程仓库的传递依赖管理，到本地文件系统的 jar 包或目录，Gradle 对所有的管理策略都提供了方便的支持
    - Gradle 的构建脚本是采用 Groovy 写的,而不是用 XML,但与其他方法不同,它并不只是展示了由一种动态语言编写的原始脚本的强大. 那样将导致维护构建变得很困难.Gradle的整体设计是面向被作为一门语言，而不是一个僵化的框架.并且Groovy是我们允许你通过抽象的 Gradle 描述你个人的 story 的黏合剂
    - Gradle Wrapper 允许你在没有安装 Gradle 的机器上执行 Gradle 构建.
* gradle元素
    - projects
        + 任何一个Gradle构建都是由一个或多个projects组成
        + 每个project包括许多可构建组成部分
        + 
    - tasks
        + 每个project由多个 tasks 组成
        + 每个 task 都代表了构建执行过程中的一个原子性操作
        + 如编译，打包，生成 javadoc，发布到某个仓库等操作
* gradle常用任务
    - clean: 删除 build 目录以及所有构建完成的文件
    - assemble: 编译并打包 jar 文件，但不会执行单元测试
    - check: 编译并测试代码
* 常用打包配置
    - 编译jar包
```groovy
jar {
    manifest {
        attributes(
            'Implementation-Title': 'Gradle Quickstart', 'Implementation-Version': version,
            'Main-Class': 'xxx.xxx.Xxx'
    }
}
```

    - 发布jar包, 执行 任务: uploadArchives 
```groovy
uploadArchives {
    repositories {
       flatDir {
           dirs 'repos'
       }
    }
}
```

    - 发布到maven仓库
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

* 编译作用域
    - compile: 编译范围依赖在所有的 classpath 中可用，同时它们也会被打包
    - runtime: runtime 依赖在运行和测试系统的时候需要，但在编译的时候不需要
    - testCompile: 测试期编译需要的附加依赖
    - testRuntime: 测试运行期需要

* 仓库配置
```groovy
repositories {
    maven { url 'http://maven.aliyun.com/nexus/content/groups/public/' }
    ivy { url "http://repo.xxxx.com/repo" }
}    
```

## 总结
* 重点: SpringBoot

---

## 学习资料

[Spring 5.2.6 文档](https://docs.spring.io/spring/docs/5.2.6.RELEASE/spring-framework-reference/core.html#spring-core)

[Spring实战（第5版 ）](https://book.douban.com/subject/34949443/)

[Spring Boot实战](https://book.douban.com/subject/26857423/)

---

## 作业

#### 作业1