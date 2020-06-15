# day05
> Spring,SpringBoot

## 今日大纲

#### Spring
* 重点

#### SpringBoot
* 重点

#### Git
* 掌握

#### Gradle
* 掌握

## Spring

#### Spring是什么？
* 超级牛叉，横行于Java服务端开发近20年的一款
* 用于构建企业级应⽤的轻量级⼀站式解决⽅方案

#### Spring能帮我们解决什么问题？
* 一种胶水，Java开发需要很多很多框架，如果每一个框架的引入都让我们去学习，想想都会令人崩溃
* 最重要的是，这种每个框架的引入学习本身是没啥太大意义的。真正有意义的是框架的使用与其实现
* 而Java作为一门免费的语言，其本身并没有去做过多的引入机制和约定。所以这也导致了，各种框架的引入真是千奇百怪
* 所以Spring用了一种极其优雅的方式帮我们做了这样的事情，慢慢有种海纳百川之势。
* 各大框架争相恐后与Spring看齐，形成了一种没有约定的事实上的标准

#### Spring环境搭建
* 导入依赖
```groovy
dependencies {
    compile('org.springframework:spring-context:4.3.27.RELEASE')
    compile('org.springframework:spring-core:4.3.27.RELEASE')
    compile('org.springframework:spring-beans:4.3.27.RELEASE')
}
```

* 编写接口与实现类
    - HelloService
    - HelloServiceImpl
* 编写配置文件
    - beans.xml

#### IOC
* Bean 工厂
* DI 依赖注入
* ClassPathXmlApplicationContext

#### Annotation Driver
* @Configuration
* @Bean
* @ComponentScan
* @Scope
* @Value
* AnnotationConfigApplicationContext

#### Unit Test

## SpringBoot

#### SpringBoot是什么

#### SpringBoot基本使用

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
* 重点: all

---

## 学习资料

[Spring 5.2.6 文档](https://docs.spring.io/spring/docs/5.2.6.RELEASE/spring-framework-reference/core.html#spring-core)

[Spring实战（第5版 ）](https://book.douban.com/subject/34949443/)

[Spring Boot实战](https://book.douban.com/subject/26857423/)

---

## 作业

#### 作业1
* 类Foo具有属性 Map,List,Date,User,Properties等属性，请使用Spring完成依赖注入
* 使用xml文件方式
