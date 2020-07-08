# day08
> mysql schema sync tools no.1

---

## MySQL Schema Sync 工具概述
#### 场景
* 线下测试
* 组内有5+QA
* 线下环境>2,或人手一套自己的测试环境
* 业务处于发展中，SQL变更还算较频繁，几乎每次业务变更都有与SQL相关的改动
* 线下环境的部署均靠个人维护，有成熟部署工具，依赖持续集成

#### 常规解决
* 流程约定
    - 约定组内qa跟进开发项目迭代，如果有SQL变更则将其变更同步至所有测试环境
    - 问题是? 约定如果不靠谱？ QA忘了做？ 开发未与QA同步变更？
* SQL变更平台自动同步
    - 与DBA沟通，在开发提交SQL变更时，一并同步多套测试环境
    - 问题是？DBA不支持，环境不互通无法操作？测试环境变化频繁？
* 你们的方案是？

#### 思考
* 针对qa自己解决的场景里，我们如果是后置得到SQL未更新时，一般处理套路如下:
    - 更新代码后，运行程序，发现有报错。开始进行排查
    - 排查时可能并不能一下就知道具体是哪个模块出的问题，因此可能要从上到下逐个排查
    - 排到具体模块确定是SQL问题时
        + 查看报错字段
        + 查看约定SQL文件
        + 查看DBA SQL审核平台的提交记录
        + 找出确定字段，编写脚本来变更，线下库为分表1024张
        + 编写for循环shell脚本去依次执行
    - 计算本次变更操作的时间
* 这个过程有难度？ 错，毫无难度，这个过程复杂？ 错，一般都不复杂
    - 问题出在哪？ 作为QA这样的场景执行2次亲身感受下就够了
    - 假设一年的时间里，你一直再重复这样的事情，那么不是你所在环境的问题，是你个人的问题
* 思考解决

#### 解决方案调研
* https://github.com/hidu/mysql-schema-sync
    - Go语言实现
* https://github.com/mmatuson/SchemaSync
    - Java语言实现

## MySQL Schema Sync 工具设计

#### 基本设计方案
* 纯Java语言实现，web服务对外提供统一能力输出
* SpringBoot作为基础框架实现

#### 实现思路
* MySQL结构同步，同步即有源，有目标，因此需要拿到两个实例的连接，然后做同步
* 如何对源和目的做对比来diff出差异？即基于两个实例的information_schema库相关的记录进行对比

## information_schema库
#### TABLES, 数据库中的表的信息
* TABLE_SCHEMA: 数据库名
* TABLE_NAME : 表名
* ENGINE : 引擎
* TABLE_ROWS : 表的行数
* DATA_LENGTH: 记录表的大小
* INDEX_LENGTH : 记录表的索引大小

#### COLUMNS, 表中的列信息
* TABLE_SCHEMA: 数据库名
* TABLE_NAME: 表名
* COLUMN_NAME: 列名
* COLUMN_KEY: 列对应索引类型 PRI,MUL
* COLUMN_TYPE: 列的数据类型 char varchar int bigint
* COLUMN_COMMENT: 注释信息
* DATA_TYPE: 列数据类型
* COLUMN_DEFAULT:列中默认值
* CHARACTER_SET_NAME: 数据库对应字符列默认字符编码, utf8
* IS_NULLABLE: 是否为null
* CHARACTER_MAXIMUM_LENGTH: 列中字符集最大长度10进制显示(字符型有效)
* CHARACTER_OCTET_LENGTH: 列中字符集最大长度8进制显示(字符型有效)
* NUMERIC_PRECISION: 列中数字长度(整数部分)
* NUMERIC_SCALE: 列中数字长度(浮点数部分)
* ORDINAL_POSITION:数据库序号
* COLLATION_NAME:列中字符列默认字符编码,utf8_general_ci ???
* EXTRA:
* PRIVILEGES:

#### SCHEMATA, 数据库的信息

#### STATISTICS, 表索引的信息

## 编码实现

#### 

