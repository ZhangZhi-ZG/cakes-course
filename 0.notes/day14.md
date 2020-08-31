# day14
> 接口自动化测试框架<第二部分>

---

## 今日大纲

#### 回顾上次课内容
* 用例格式化校验
* 用例驱动执行

#### http client

#### mysql client

#### param holder

#### data driver

#### assert

#### alarm

#### report

#### 总结

---

## http client

#### 正常基于 okhttp 进行封装即可

---

## mysql client

#### 为什么要自己在做一个封装？

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

## assert

#### 封装实现
* 对常用json的封装

---

## alarm

#### 实现思路
* 单方法执行失败时的报警处理(较少)
* 批量驱动运行时的报警处理(较多)

#### 实现关键点
* 运行时扩展实现TestExecutionListener接口,在结束后判断其Status为失败即触发报警策略

---

## report

#### 实现思路


#### 实现关键点

---

## 总结

#### 自动化是一个烂大街的东西

#### 自动化是一个看似水很浅，没啥技术含量的东西

#### 自动化是一个看似谁都可以玩的东西

#### 自动化看似是一个实习生在做，技术大佬也在做，大家都是做自动化的，那么真的就是一样的吗？
