package course.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Producer相关操作
 * <p>
 * partition理解：
 * <p>
 * ---> MySQL 分库分表。 原表 有5000万条记录. 做千表拆分后每张表有5万数据。
 * --------> order表， 取出order_id, eg: 123_123464675. order_id计算一下hash值. 24242342 % 1024 = 985. ==> order_985
 * <p>
 * <p>
 * ---> kafka能够实现大吞吐,高并发
 * --------> partition 本质跟分表逻辑是一样的只不过kafka是天生，默认就支持了，不需要我们在自己去为消息选择该往哪里去分配，只要给定分区的数量即可
 * ------------> topic / 00000001.log , 0000002.log , 0000003.log
 * <p>
 * -----> 业务场景： 美团 passport, 外卖8000万请求， 酒店200请求
 * -------》 0000.log,0001.log,0002.log.    0000x.log
 */
public class ProducerOperating {

    private static final String TOPIC_NAME = "hello-kafka";

    /**
     * 简单的发送一条消息(异步)
     *
     * @param key
     * @param msg
     */
    public static void sendMsg(String key, String msg) {
        // 构建kafka producer的配置参数
        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        prop.setProperty(ProducerConfig.RETRIES_CONFIG, "0");
        prop.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "16384");
        prop.setProperty(ProducerConfig.LINGER_MS_CONFIG, "16384");
        prop.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG, "33554432");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        /**
         * 此配置是 Producer 在确认一个请求发送完成之前需要收到的反馈信息的数量。 这个参数是为了保证发送请求的 "可靠性"
         *
         * acks = all  最严格的一种策略，就是必须收到，                    必须一条
         * acks = 0    最不严格的策略，消息可能被收到0条，也可能收到1条。     最多一条
         * acks = 1    相对严格， 消息可以被收到1到多条。                  至少一条
         */
        prop.setProperty(ProducerConfig.ACKS_CONFIG, "all");

        // 构建出kafka producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(prop);

        // 创建一个消息实体, 指定topic, 以及消息的key,msg
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, key, msg);

        // 消息发送
        producer.send(record);

        // 资源关闭
        producer.close();
    }

    /**
     * 发送多条消息(异步)
     *
     * @param key
     * @param msg
     */
    public static void sendMultipleMsg(String key, String msg) {
        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(prop);

        for (int i = 0; i < 10000; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME,
                    key + i,
                    msg + i);

            // 不做结果处理的话就是异步模式
            producer.send(record);
        }

        producer.close();
    }

    /**
     * 消息发送(同步)
     * <p>
     * 伪同步: 用异步+阻塞的模式来实现的 同步能力
     *
     * @param key
     * @param msg
     */
    public static void sendMsgWithSync(String key, String msg) throws Exception {
        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(prop);

        for (int i = 0; i < 10000; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME,
                    key + i,
                    msg + i);

            // 处理结果返回，得到future, future.get()是一个阻塞操作,来模拟实现同步能力
            Future<RecordMetadata> future = producer.send(record);

            RecordMetadata metadata = future.get();

            System.out.printf("send msg to topic = %s, partition = %d, offset = %s \n", metadata.topic(), metadata.partition(), metadata.offset());
        }

        producer.close();
    }

    /**
     * 消息发送+结果回调
     *
     * @param key
     * @param msg
     * @throws Exception
     */
    public static void sendMsgWithCallback(String key, String msg) throws Exception {
        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(prop);


        for (int i = 0; i < 10000; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME,
                    key + i,
                    msg + i);

            // 处理结果返回，得到future, future.get()是一个阻塞操作,来模拟实现同步能力
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    System.out.printf("send msg to topic = %s, partition = %d, offset = %s \n", metadata.topic(), metadata.partition(), metadata.offset());
                }
            });
        }

        producer.close();
    }

    /**
     * 消息发送，自定义消息的发送分区数。需要在producer上进行配置
     * <p>
     * prop.setProperty(ProducerConfig.PARTITIONER_CLASS_CONFIG, SimplePartitioner.class.getName());
     *
     * @param key
     * @param msg
     * @throws Exception
     */
    public static void sendMsgWithPartition(String key, String msg) throws Exception {
        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.PARTITIONER_CLASS_CONFIG, SimplePartitioner.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(prop);


        for (int i = 0; i < 10000; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME,
                    key + i,
                    msg + i);

            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    System.out.printf("send msg to topic = %s, partition = %d, offset = %s \n", metadata.topic(), metadata.partition(), metadata.offset());
                }
            });
        }

        producer.close();
    }

    /**
     * 发送单条消息,且为异步+阻塞的伪同步
     *
     * @param key
     * @param msg
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void sendSingleMsgForSync(String key, String msg) throws Exception {
        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        prop.setProperty(ProducerConfig.RETRIES_CONFIG, "0");
        prop.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "16384");
        prop.setProperty(ProducerConfig.LINGER_MS_CONFIG, "16384");
        prop.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG, "33554432");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        prop.setProperty(ProducerConfig.ACKS_CONFIG, "all");

        KafkaProducer<String, String> producer = new KafkaProducer<>(prop);

        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, key, msg);

        Future<RecordMetadata> future = producer.send(record);

        RecordMetadata metadata = future.get();

        System.out.printf("send msg to topic = %s, partition = %d, offset = %s \n", metadata.topic(), metadata.partition(), metadata.offset());

        producer.close();
    }

}
