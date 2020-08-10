# day11
> kafka

---

## 概述

#### 简介
* http://kafka.apache.org/
* kafka 《A distributed streaming platform》
* 基于zk的分布式(distributed)消息系统

#### 特点
* 高吞吐
* 高性能
* 实时
* 可靠

---

## kafka安装
> http://kafka.apache.org/downloads
> https://zookeeper.apache.org/releases.html

#### 版本选择
* kafka最新: kafka_2.13-2.5.0.tgz
* zk: Apache ZooKeeper 3.6.1

#### 安装部署(docker环境)
* 下载centos7.x镜像
    - docker search centos
        + 查找,选择<The official build of CentOS.>
    - docker pull centos:latest
        + 下载centos镜像
* 运行centos镜像
    - docker run -d -i --name kafka-centos -p 2181:2181 -p 9092:9092 -t <your image id> /bin/bash
        + 启动刚下载的 centos 镜像
        + -p 开启对外端口,外部可以访问,2181是zk端口,9092是kafka
        + /bin/bash 启动后确保centos可以后台运行,否则会启动就退出
* 进入centos容器
    - docker attach <container id>
* 下载安装包
    - wget https://mirror.bit.edu.cn/apache/zookeeper/zookeeper-3.6.1/apache-zookeeper-3.6.1-bin.tar.gz
    - wget https://mirror.bit.edu.cn/apache/kafka/2.5.0/kafka_2.13-2.5.0.tgz
* 安装jdk环境,并配置相关环境变量
* 安装zk
    - 解压
    - 配置
    - 启动
    - 测试
* 安装kafka
    - 解压
    - 配置(config/server.properties)
        + listeners=PLAINTEXT://<your host>:9092
        + advertised.listeners=PLAINTEXT://your.host.name:9092
        + zookeeper.connect=localhost:2181
    - 启动
        + 启动kafka broker
            * ./bin/kafka-server-start.sh ./config/server.properties &
        + 关闭kafka broker
            * ./bin/kafka-server-stop.sh
    - 测试
        + 创建topic
            * ./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic hello-kafka
            * ./bin/kafka-topics.sh --list --zookeeper localhost:2181
        + 消费者监听
            * ./bin/kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --from-beginning --topic hello-kafka
        + 生产者生产
            * ./bin/kafka-console-producer.sh --broker-list 127.0.0.1:9092 --topic hello-kafka

#### Mac安装
* 解压
* 配置
* 启动
* 测试

---

## Kafka基础

#### 基本概念
* Topic(主题): 逻辑概念，一般由1-n个partitions组成
* Partition: 实际消息存储单位
* Producer(生产者): 消息的生产方
* Consumer(消费者): 消息的消费方

---

## Java Client

#### 引入依赖
```java
implementation('org.apache.kafka:kafka-clients:2.5.0')
```

#### Admin Client
* 构建AdminClient
```java
public static AdminClient createAdminClient() {
    Map<String, Object> conf = Maps.newHashMap();

    conf.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");

    AdminClient adminClient = AdminClient.create(conf);

    return adminClient;
}
```

* 创建Topic
```java
/**
 + 创建topic
 */
public static void createTopics(String topicName) throws Exception {
    AdminClient adminClient = BuildAdminClient.createAdminClient();

    /**
     + name: topic名字
     + numPartitions: 分区数
     + replicationFactor: 副本数,要下于broker集群机器的数量
     */
    NewTopic topic = new NewTopic(topicName, 1, Short.parseShort("1"));

    // 创建主题,可以一起创建多个,返回的结果中根据主题名称为key,结果封装在future中
    CreateTopicsResult result = adminClient.createTopics(Collections.singleton(topic));

    // 创建结果
    Map<String, KafkaFuture<Void>> values = result.values();
    values.forEach((key, future) -> {
        System.out.println("key = " + key + ", future.isCompletedExceptionally() = " + future.isCompletedExceptionally());
    });

    // 关闭client
    adminClient.close();
}
```

* 展示Topic
```java
/**
 + 列出所有的topic
 */
public static void listTopics() throws Exception {
    AdminClient adminClient = BuildAdminClient.createAdminClient();

    ListTopicsResult result = adminClient.listTopics();

    Set<String> names = result.names().get();
    System.out.println("topic names = " + names);

    Collection<TopicListing> listingCollection = result.listings().get();
    System.out.println("listingCollection = " + listingCollection);

    Map<String, TopicListing> listingMap = result.namesToListings().get();
    System.out.println("listingMap = " + listingMap);

    // 关闭client
    adminClient.close();
}
```

* 待选项的列出所有topic
```java
/**
 + 带参数的列出所有的topic
 */
public static void listTopicsByOptions() throws Exception {
    AdminClient adminClient = BuildAdminClient.createAdminClient();

    ListTopicsOptions options = new ListTopicsOptions();
    options.listInternal(true); // 列出内部的Topic

    ListTopicsResult result = adminClient.listTopics(options);

    Set<String> names = result.names().get();
    System.out.println("topic names = " + names);

    Collection<TopicListing> listingCollection = result.listings().get();
    System.out.println("listingCollection = " + listingCollection);

    Map<String, TopicListing> listingMap = result.namesToListings().get();
    System.out.println("listingMap = " + listingMap);

    // 关闭client
    adminClient.close();
}

```

* 删除Topic
```java
/**
 + 删除topic
 *
 + @param topicName
 */
public static void removeTopic(String topicName) throws Exception {
    AdminClient adminClient = BuildAdminClient.createAdminClient();

    DeleteTopicsResult result = adminClient.deleteTopics(Collections.singletonList(topicName));

    result.all().get();

    // 关闭client
    adminClient.close();
}

```

* 描述Topic
```java
/**
 + 描述topic
 */
public static void describeTopics(String topicName) throws Exception {
    AdminClient adminClient = BuildAdminClient.createAdminClient();

    DescribeTopicsResult result = adminClient.describeTopics(Collections.singletonList(topicName));

    Map<String, TopicDescription> descriptionMap = result.all().get();

    descriptionMap.forEach((name, desc) -> {
        System.out.println("name = " + name + ", desc = " + desc);
    });

    // 关闭client
    adminClient.close();
}
```

* 描述Topic配置
```java
/**
 + 描述topic 配置
 */
public static void describeTopicConfig(String topicName) throws Exception {
    AdminClient adminClient = BuildAdminClient.createAdminClient();

    // ConfigResource.Type == BROKER_LOGGER((byte) 8), BROKER((byte) 4), TOPIC((byte) 2), UNKNOWN((byte) 0);
    DescribeConfigsResult result = adminClient.describeConfigs(Collections.singletonList(new ConfigResource(ConfigResource.Type.TOPIC, topicName)));

    Map<ConfigResource, Config> configMap = result.all().get();

    configMap.forEach((r, c) -> {
        System.out.println("ConfigResource = " + r + ", Config = " + c);
    });

    // 关闭client
    adminClient.close();
}
```

* 修改配置信息
```java
   /**
 + 修改配置信息
 *
 + @throws Exception
 */
public static void updateTopicConfig(String topicName) throws Exception {
    AdminClient adminClient = BuildAdminClient.createAdminClient();

    // 指定要修改的源
    ConfigResource configResource = new ConfigResource(ConfigResource.Type.TOPIC, topicName);
    // 建立修改的配置项
    Config config = new Config(Collections.singletonList(new ConfigEntry("preallocate", "true")));

    // 参数构造
    Map<ConfigResource, Config> configs = Maps.newHashMap();
    configs.put(configResource, config);

    // 执行修改
    AlterConfigsResult result = adminClient.alterConfigs(configs);
    result.all().get();

    // 对单机版的支持总是有些问题.
    // adminClient.incrementalAlterConfigs()

    // 关闭client
    adminClient.close();
}
```

* 修改分区
```java
/**
 + 分区的修改,kafka中 只能做增加操作,删除一类的不可以
 *
 + @param topicName
 */
public static void updatePartition(String topicName, int totalCount) throws Exception {
    AdminClient adminClient = BuildAdminClient.createAdminClient();

    // 构建基于topicName的修改Map配置
    Map<String, NewPartitions> newPartitionsMap = Maps.newHashMap();
    newPartitionsMap.put(topicName, NewPartitions.increaseTo(totalCount));

    // 执行修改
    CreatePartitionsResult result = adminClient.createPartitions(newPartitionsMap);

    result.all().get();

    adminClient.close();
}
```

#### Producer
* 异步发送
```java
public static void sendSimpleMsg(String topicName, String key, String msg) throws Exception {
    // 配置producer
    Properties prop = new Properties();
    prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    prop.setProperty(ProducerConfig.ACKS_CONFIG, "all");
    prop.setProperty(ProducerConfig.RETRIES_CONFIG, "0");
    prop.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "16384");
    prop.setProperty(ProducerConfig.LINGER_MS_CONFIG, "16384");
    prop.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG, "33554432");
    // 序列化实现类,可以自己做扩展
    prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    // 构建Producer消息发送的最主要的对象,也是入口
    Producer<String, String> producer = new KafkaProducer<>(prop);

    // 构建一条消息实体,消息记录
    ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, key, msg);

    // 执行发送
    producer.send(record);

    // 资源关闭
    producer.close();
}
```
* 异步+阻塞
```java
public static void sendSimpleMsg(String topicName, String key, String msg) throws Exception {
    // 配置producer
    Properties prop = new Properties();
    prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    prop.setProperty(ProducerConfig.ACKS_CONFIG, "all");
    prop.setProperty(ProducerConfig.RETRIES_CONFIG, "0");
    prop.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "16384");
    prop.setProperty(ProducerConfig.LINGER_MS_CONFIG, "16384");
    prop.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG, "33554432");
    // 序列化实现类,可以自己做扩展
    prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    // 构建Producer消息发送的最主要的对象,也是入口
    Producer<String, String> producer = new KafkaProducer<>(prop);

    // 构建一条消息实体,消息记录
    ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, key, msg);

    // 执行发送
    Future<RecordMetadata> future = producer.send(record);

    // 获取结果,会阻塞.可以认为是进行了同步操作。伪同步
    RecordMetadata metadata = future.get();
    System.out.println("return partition = " + metadata.partition() + ", offset = " + metadata.offset());

    // 资源关闭
    producer.close();
}
```

* 异步+回调
```java
public static void sendSimpleMsgForCallback(String topicName, String key, String msg) throws Exception {
    // 配置producer
    Properties prop = new Properties();
    prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    prop.setProperty(ProducerConfig.ACKS_CONFIG, "all");
    prop.setProperty(ProducerConfig.RETRIES_CONFIG, "0");
    prop.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "16384");
    prop.setProperty(ProducerConfig.LINGER_MS_CONFIG, "16384");
    prop.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG, "33554432");
    // 序列化实现类,可以自己做扩展
    prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    // 构建Producer消息发送的最主要的对象,也是入口
    Producer<String, String> producer = new KafkaProducer<>(prop);

    // 构建一条消息实体,消息记录
    ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, key, msg);

    // 执行发送,并添加一个回调处理，注意此时是非阻塞
    producer.send(record, new Callback() {
        @Override
        public void onCompletion(RecordMetadata metadata, Exception exception) {
            System.out.println("return partition = " + metadata.partition() + ", offset = " + metadata.offset());
        }
    });

    // 资源关闭
    producer.close();
}
```

* 自定义分区器,即指定特定的key进入特定的分区.负载均衡
    - implements org.apache.kafka.clients.producer.Partitioner
    - 添加Producer配置
        + prop.setProperty(ProducerConfig.PARTITIONER_CLASS_CONFIG, "");

#### Consumer
* 接收消息/自动提交
```java
/**
 + 最简单的demo,不推荐
 *
 + @param topicName
 + @throws Exception
 */
public static void consumeSimple(String topicName) throws Exception {
    // consumer配置项
    Properties props = new Properties();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    props.put("group.id", "test");
    props.put("enable.auto.commit", "true"); // 自动提交
    props.put("auto.commit.interval.ms", "1000"); // 提交间隔
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

    // 构建Consumer
    KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

    // 订阅指定的topic,课指定订阅多个 topic
    consumer.subscribe(Collections.singleton(topicName));

    // 处理消息接收,此处是
    while (true) {
        // 消息拉取,pull, 给定时间间隔是 每个 100毫秒
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
        for (ConsumerRecord<String, String> record : records)
            System.out.printf("partition = %s, offset = %d, key = %s, value = %s%n", record.partition(), record.offset(), record.key(), record.value());
    }
}

```

* 接收消息/手动处理提交
```java
public static void consumeSimple(String topicName) throws Exception {
    // consumer配置项
    Properties props = new Properties();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    props.put("group.id", "test");
    props.put("enable.auto.commit", "false");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

    // 构建Consumer
    KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

    // 订阅指定的topic,课指定订阅多个 topic
    consumer.subscribe(Collections.singleton(topicName));

    // 处理消息接收,此处是
    while (true) {
        // 消息拉取,pull, 给定时间间隔是 每个 100毫秒
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
        for (ConsumerRecord<String, String> record : records) {
            System.out.printf("partition = %s, offset = %d, key = %s, value = %s%n", record.partition(), record.offset(), record.key(), record.value());
        }

        consumer.commitAsync();
    }
}
```

---

## Kafka 集成进SpringBoot

#### 集成步骤

#### 添加依赖
* implementation('org.springframework.kafka:spring-kafka:2.5.4.RELEASE')

#### 添加application.yml
```yml
server:
  port: 8899

spring:
  kafka:
    bootstrap-servers: 127.0.0.1:9092
    producer:
      # 发生错误后，消息重发的次数。
      retries: 0
      #当有多个消息需要被发送到同一个分区时，生产者会把它们放在同一个批次里。该参数指定了一个批次可以使用的内存大小，按照字节数计算。
      batch-size: 16384
      # 设置生产者内存缓冲区的大小。
      buffer-memory: 33554432
      # 键的序列化方式
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      # 值的序列化方式
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
      # acks=0 ： 生产者在成功写入消息之前不会等待任何来自服务器的响应。
      # acks=1 ： 只要集群的首领节点收到消息，生产者就会收到一个来自服务器成功响应。
      # acks=all ：只有当所有参与复制的节点全部收到消息时，生产者才会收到一个来自服务器的成功响应。
      acks: 1
    consumer:
      # 自动提交的时间间隔 在spring boot 2.X 版本中这里采用的是值的类型为Duration 需要符合特定的格式，如1S,1M,2H,5D
      auto-commit-interval: 1S
      # 该属性指定了消费者在读取一个没有偏移量的分区或者偏移量无效的情况下该作何处理：
      # latest（默认值）在偏移量无效的情况下，消费者将从最新的记录开始读取数据（在消费者启动之后生成的记录）
      # earliest ：在偏移量无效的情况下，消费者将从起始位置读取分区的记录
      auto-offset-reset: earliest
      # 是否自动提交偏移量，默认值是true,为了避免出现重复数据和数据丢失，可以把它设置为false,然后手动提交偏移量
      enable-auto-commit: false
      # 键的反序列化方式
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      # 值的反序列化方式
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
    listener:
      # 在侦听器容器中运行的线程数。
      concurrency: 5
      #listner负责ack，每调用一次，就立即commit
      ack-mode: manual_immediate
      missing-topics-fatal: false
```

#### 新建Controller+主启动类(略)

#### 新建Producer
```java
@Component
public class CommonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMsg(String msg) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(KafkaConst.COMMON_TOPIC, msg);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                LOGGER.info("producer send success result = {}" + result.toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                LOGGER.info("producer send failed. msg={}", throwable.getMessage());
            }
        });
    }
}
```

#### 新建Consumer
```java
@Component
public class CommonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonConsumer.class);

    @KafkaListener(topics = KafkaConst.COMMON_TOPIC, groupId = KafkaConst.GROUP_ONE)
    public void consumeForGroupOne(ConsumerRecord<String, String> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional<String> msgOptional = Optional.ofNullable(record.value());
        if (msgOptional.isPresent()) {
            Object msg = msgOptional.get();
            LOGGER.info("consumeForGroupOne start: topic={}, msg={}", topic, msg);
            ack.acknowledge();
        }
    }

    @KafkaListener(topics = KafkaConst.COMMON_TOPIC, groupId = KafkaConst.GROUP_TWO)
    public void consumeForGroupTwo(ConsumerRecord<String, String> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional<String> msgOptional = Optional.ofNullable(record.value());
        if (msgOptional.isPresent()) {
            Object msg = msgOptional.get();
            LOGGER.info("consumeForGroupTwo start: topic={}, msg={}", topic, msg);
            ack.acknowledge();
        }
    }
}
```

#### kafka 配置敞亮
```java
public interface KafkaConst {

    String COMMON_TOPIC = "hello-kafka";

    String GROUP_ONE = "common-group1";

    String GROUP_TWO = "common-group2";
}
```

---

## 关于业务代码梳理

#### 订单系统
* 模块划分
    - order-api
        + controller
    - order-service
        + rpc: 
        + 代码完全飞了
        + 账号系统，用户，账户，支付，网关，定时任务，回调。
    - order-dao
        + order 表 
            * order_id
        + order dao 类，OrderMapper.class
            * insert
            * update
            * query
        + order_detail 
            * order_id
            * order_detail_id
        + order_detail 表 OrderDetailMapper.class
            * insert
            * update
            * query
        + order_detail_log 表

* 搞清楚这个模块的边界，问人.
    - 


---

## 今日总结

---

## 参考资料

* [kafka中文文档](http://kafka.apachecn.org/documentation.html)



