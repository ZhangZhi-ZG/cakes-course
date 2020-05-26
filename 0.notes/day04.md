# day04
> Java8,设计模式, git, gradle

---

## 今日大纲

#### Java8
* lambda
* stream

#### 设计模式
* 单例
* 工厂
* 建造者

#### 常用工具
* git
* gradle

#### 总结
* 重点

#### 学习资料
* 

#### 作业
* 

---

## Java8

#### Java8是什么
* 其实不是啥新技术，就是jdk1.8*的一种说法
* 因为其新特性具有创造性改变，故此Java8成了一种新技术一样

#### Lambda表达式
* 函数式接口
* 

#### Stream流化
* 将集合流化
    - xxx.stream()         // 创建普通流
    - xxx.parallelStream() // 创建并行流
* 数组类支持
    - Arrays.stream()

#### Stream案例实操
* 示例1
```java
List<String> myList =
    Arrays.asList("a1", "a2", "b1", "c2", "c1");

myList
    .stream()
    .filter(s -> s.startsWith("c"))
    .map(String::toUpperCase)
    .sorted()
    .forEach(System.out::println);
```

* 示例2
```java
Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
```

* 示例3: 找出全文的单词，转小写，并排序
```java
public static void main(String[] args) throws IOException {
    String path = "/Users/haoc/course/code/cakes-course/basic/src/main/java/course/basic/App.java";
    BufferedReader br = new BufferedReader(new FileReader(path));
    List<String> words = br.lines()
            .flatMap(line -> Stream.of(line.split(" ")))
            .filter(word -> word.length() > 0)
            .map(String::toLowerCase)
            .distinct()
            .sorted()
            .collect(Collectors.toList());
    br.close();
    words.forEach(System.out::println);
}
```

* 示例4
```java
public static void main(String[] args) throws IOException {
    List<Person> persionList = new ArrayList<Person>();
    persionList.add(new Person(1, "张三", "男", 38));
    persionList.add(new Person(2, "小小", "女", 2));
    persionList.add(new Person(3, "李四", "男", 65));
    persionList.add(new Person(4, "王五", "女", 20));
    persionList.add(new Person(5, "赵六", "男", 38));
    persionList.add(new Person(6, "大大", "男", 65));

    //1、只取出该集合中所有姓名组成一个新集合
    List<String> nameList = persionList.stream().map(Person::getName).collect(Collectors.toList());
    System.out.println(nameList.toString());

    //2、只取出该集合中所有id组成一个新集合
    List<Integer> idList = persionList.stream().mapToInt(Person::getId).boxed().collect(Collectors.toList());
    System.out.println(idList.toString());

    //3、list转map，key值为id，value为Person对象
    Map<Integer, Person> personmap = persionList.stream().collect(Collectors.toMap(Person::getId, person -> person));
    System.out.println(personmap.toString());

    //4、list转map，key值为id，value为name
    Map<Integer, String> namemap = persionList.stream().collect(Collectors.toMap(Person::getId, Person::getName));
    System.out.println(namemap.toString());

    //5、进行map集合存放，key为age值 value为Person对象 它会把相同age的对象放到一个集合中
    Map<Integer, List<Person>> ageMap = persionList.stream().collect(Collectors.groupingBy(Person::getAge));
    System.out.println(ageMap.toString());

    //6、获取最小年龄
    int ageMin = persionList.stream().mapToInt(Person::getAge).min().getAsInt();
    System.out.println("最小年龄为: " + ageMin);

    //7、获取最大年龄
    int ageMax = persionList.stream().mapToInt(Person::getAge).max().getAsInt();
    System.out.println("最大年龄为: " + ageMax);

    //8、集合年龄属性求和
    int ageAmount = persionList.stream().mapToInt(Person::getAge).sum();
    System.out.println("年龄总和为: " + ageAmount);


    //9、查找年龄大于20岁的人数
    long age = persionList.stream().filter(p -> p.getAge() > 20).count();
    System.out.println(age);

    //10、查找年龄大于20岁，性别为男的人数
    List<Person> ageList = persionList.stream().filter(p -> p.getAge() > 20).filter(p -> "男".equals(p.getSex())).collect(Collectors.toList());
    System.out.println(ageList.size());
}

static class Person {
    int id;
    String name;
    String sex;
    int age;

    public Person(int id, String name, String sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }
}
```

---

## 设计模式
#### 模板模式
* ??? 还记得否? 精髓是啥？

#### 单例模式

* 单例设计模式是什么？有啥么用？
    - 一个Java进程中只有一个实例，且对外提供唯一访问
    - 全局唯一

* 单例的使用场景(个人推荐)
    - 各种池类
    - 资源/构建管理类

* 单例的常用写法(个人推荐)
    - 内部类
    - 枚举

* 单例的其他写法？
    - 懒汉？
    - 饿汉？线程安全与不安全

#### 工厂模式

* 工厂设计模式是什么？
    - 在基类中定义创建对象的一个接口，让子类决定实例化哪个类。工厂方法让一个类的实例化延迟到子类中进行

* 工厂的使用场景
    - 一些开源框架实践
        + Spring中通过getBean("xxx")获取Bean
        + ActiveMQ建立连接
```java
ConnectionFactory factory = new ActiveMQConnectionFactory(tcp:/x.x.x.x:61616");
Connection connection = factory.createConnection();
```

* 工厂设计模式有啥么用？
    - 解耦: 把对象的创建和使用的过程分开
    - 减少重复: 挡创建对象的过程比较复杂时，可以考虑将此部分创建抽离

* 工厂示例1
    - Animal
        + run
        + eat
    - Dog
    - Cat
* 工厂示例2
    - 基于反射


#### 建造者

* 建造者设计模式是什么？有啥么用？
    - 链式调用

* 建造者的常用写法

* 建造者的神器？
    - lombok

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

---

## 总结
* 重点: java8,设计模式

---

## 学习资料

[Java 8实战](https://book.douban.com/subject/26772632/)

[Head First 设计模式](https://book.douban.com/subject/2243615/)

---

## 作业

#### 作业一: 将之前作业反复练习

#### 作业二: 预习Spring,MyBatis