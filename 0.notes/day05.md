# day05
> Spring,SpringBoot

## 今日大纲

#### Spring
* 重点

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

#### AOP
* 从一个问题说开区
* 基于jdk 动态代理来实现
* Spring帮我们的实现方案
* 详细解说AOP
    - 通知
    - 切点
    - 切面

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
