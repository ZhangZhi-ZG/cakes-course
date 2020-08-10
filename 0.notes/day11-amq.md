# Active MQ

---

## 1.消息队列基础

### 为什么需要mq
* 点餐案例

### MQ可以解决什么问题
* 异步
* 削峰
* 解耦

### 消息队列产品
* kafka
* rocketmq
* rabbitmq(erlang)
* activemq(java)(jms)
* qunar(qmq)
* jd(jmq)
* didi(ddmq)
* zeromq

### 消息的模式
##### queue
* 点对点

##### topic

## 2.Active MQ

### 2.0 active mq搭建

##### 官网
[ActiveMQ官网](http://activemq.apache.org/)

##### 解压
```shell
>tar -zxvf apache-activemq-5.15.9-bin.tar.gz -C /opt
>mkdir /usr/local/activemq5.15.9
>cp -r /opt/apache-activemq-5.15.9/* /usr/local/activemq5.15.9/
```

##### 启动
```shell
>/usr/local/activemq5.15.9/bin/activemq start

# 检查启动状态
[root@cbooy bin]# jps
xxxxx activemq.jar

# activemq启动的默认端口号 61616
[root@cbooy bin]# lsof -i:61616
COMMAND   PID USER   FD   TYPE     DEVICE SIZE/OFF NODE NAME
java    38396 root  132u  IPv4 2079199650      0t0  TCP *:61616 (LISTEN)
```

##### 其他基本命令
```shell
> activemq restart # 重启
> activemq stop    # 关闭
> activemq start > /activemq_home/logs/activemq.log   # 落地相关信息,打印日志
```

##### 指定配置文件的启动
* ./bin/activemq start xbean:file:/path/to/config/activemq.xml

##### 后台图形化页面支持
* http://127.0.0.1:8161/admin
    - 默认用户名/密码, admin/admin
    - 用户名&密码修改, conf/loging.xx?
* 图形化页面相关信息说明
    - Number Of Pending Messages
        + 等待消费的消息
        + 未出队列的数量
    - Number Of Consumers
        + 消费者数量
    - Messages Enqueued
        + 进队消息数,进入队列的总数包括出队的消息数
    - Messages Dequeued
        + 出队消息数,即消费者消费后的消息

### 2.1 queue的基本使用
##### 生产流程
* 创建连接工厂对象
* 从工厂中建立一个连接并开启(Connection)
* 从连接中建立一个会话(Session)
* 基于会话建立目的地(Queue)
* 基于会话创建生产者(Producer)
* 在会话的基础上创建一条消息(Message)
* 生产者将消息发出
* 资源关闭

##### 消费流程
* 创建连接工厂对象
* 从工厂中建立一个连接并开启(Connection)
* 从连接中建立一个会话(Session)
* 基于会话建立目的地(Queue)
* 基于会话创建消费者(Consumer)
* 消费者接收消息
* 资源关闭

### 2.2 topic的基本使用
##### 生产流程
* 创建连接工厂对象
* 从工厂中建立一个连接并开启(Connection)
* 从连接中建立一个会话(Session)
* 基于会话建立目的地(Topic)
* 基于会话创建生产者(Producer)
* 在会话的基础上创建一条消息(Message)
* 生产者将消息发出
* 资源关闭

##### 消费流程
* 创建连接工厂对象
* 从工厂中建立一个连接并开启(Connection)
* 从连接中建立一个会话(Session)
* 基于会话建立目的地(Topic)
* 基于会话创建消费者(Consumer)
* 消费者接收消息
* 资源关闭

### 2.3 SpringBoot整合
#### Producer
##### 添加依赖
* implementation('org.springframework.boot:spring-boot-starter-activemq')

##### amq连接
```groovy
spring:
  activemq:
    broker-url: tcp://127.0.0.1:61616
```

##### 配置ContainerFactory
```java
@Bean
public JmsListenerContainerFactory topicListenerContainerFactory(ConnectionFactory connectionFactory){
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    // 必须设置为true，false则表示是queue类型
    factory.setPubSubDomain(true);
    return factory;
}
```

##### 配置Queue
```java
  @Bean
  public Queue buildQueue() {
    return new ActiveMQQueue("xxxx-queue");
  }
```

##### 配置Topic
```java
@Bean
  public Topic topic() {
    return new ActiveMQTopic("xxxx-topic") ;
  }
```

#### Consumer

##### 配置监听器
```java
@JmsListener(destination = xxx-topic, containerFactory = "xxxxFactory")
public void received(String message) {
    log.info("consumer received:[{}]", message);
}
```
