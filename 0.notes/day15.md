# day15
> 接口自动化测试框架<第三部分>

---

## 今日大纲

#### data driver

#### mysql client

#### env profile

#### param holder

#### assert

#### case demo

#### mock support

---

## mysql client

#### 为什么要自己在做一个封装？

#### 场景
* 我们一般写接口测试，是很多个工程的测试代码放在一处。
* 我们的被测系统一般是 10+模块，每个模块3-5张表。大约 30-50张表
* 基于以上两个小场景，我们的接口测试框架，需要去构建的实体和表操作大概就是30+
* 新的需求提测了，加了一个字段。新家表。

#### 思考？？？
* 我想做的是讲 SQL执行与具体的表分离。
    - select * from tb_order where id=xxx and order_id=xxx;
    - 这时如果order表中添加了字段，比如加了一个 create_time, modify_time, success_time.
    - 由于用MyBatis这样的框架，为 数据库表和实体做了映射，且是完全映射。
* 所以我们要做的就是将 sql与表分离。 将返回结果做统一处理。
* 问题: 如果不使用数据实体，那么现在面临的是，我都不知道这个表里有哪些字段。。

#### 编码设计
* 基于spring-jdbc实现,NamedParameterJdbcTemplate
    - implementation('org.springframework:spring-jdbc:5.2.8.RELEASE')
* 也完全可以自己手写jdbc实现

---

## param holder

#### 实现思路
* 收拢各种参数定义，整洁代码

#### 实现关键点
* 基于反射对对象进行解析


---

## data driver

#### 实现思路
* 数据驱动即一般做法为将测试数据放置于文件中，如csv文件，用例在运行时加载文件一行行读取出来然后组装测试用例
* 我们要做的也是类似的，只不过我们是基于junit5来进行扩展，那该如何驱动数据文件呢？
    - 首先在我们每个测试的用例上，我们加上一个注解用来标识数据源文件在哪里
    - 然后编写用例带着对应参数（支持自定义类型）
    - 在用例运行时，从注解上找到源数据文件，取出数据，解析完成后，按照用例方法的参数描述进行注入

#### 实现关键点
* 扩展类实现接口 TestTemplateInvocationContextProvider
* 在方法 provideTestTemplateInvocationContexts 返回时即为每一次解析的数据
    - 自定义类实现TestTemplateInvocationContext接口与ParameterResolver
    - 在resolveParameter中实现参数的解析

---

## env profile

#### 环境切换意义何在？
* 多套环境，多个人执行用例时需要运行在不同的环境上。
* 此时该如何切换环境，直接修改配置文件？

#### 实现思路
* EnvProfile来标注我们希望当前用例运行时的profile信息
* 基于junit5来做扩展，在用例运行前，将此Profile的数据 塞进一个全局信息中。
* 后续需要来用profile切换时，从此全局信息中捞出来具体profile是啥
* 为保配置读取失败，可以设置一个兜底的，如config-default.yml

#### 思考
* 如果每个用例都写一个profile，我们的profile难道每次都改？
    - profile的用途你想想是为了单个case逐个去跑用的吗？
    - 单个case确实有使用的必要，比如临时切换个环境。。。
    - 但是更多的profile是给用例批量运行时去使用的。所以这个时候，我们批量执行时，我得目的很明确就是要跑在具体的环境上。所以此时只需要设置一次即可，后续的具体用例即使有标签，但是全部忽略
    - 即与CaseSelector一起联合使用
 
---

## assert

#### 封装实现
* 对常用json的封装

---

## case demo

----

## Mock Support

---

## 总结

#### 自动化是一个烂大街的东西

#### 自动化是一个看似水很浅，没啥技术含量的东西

#### 自动化是一个看似谁都可以玩的东西

#### 自动化看似是一个实习生在做，技术大佬也在做，大家都是做自动化的，那么真的就是一样的吗？
