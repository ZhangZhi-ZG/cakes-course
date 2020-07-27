package course.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;

/**
 * 消费者处理
 */
public class ConsumerOperating {

    private static final String TOPIC_NAME = "hello-kafka";

    /**
     * 消费者消费消息，做自动提交
     * <p>
     * 配置如下:
     * prop.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
     */
    public static void consumeForAutoCommit() { // addnode -> // NODE: createOrder Order 订单系统的插入方法，
        // consumer的配置信息封装
        Properties prop = new Properties();
        prop.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        prop.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        prop.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        prop.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        prop.setProperty(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        prop.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "test");

        // 创建consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(prop);

        consumer.subscribe(Collections.singleton(TOPIC_NAME));

        // 轮训处理消息
        while (true) {
            // 拉消息
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            Iterator<ConsumerRecord<String, String>> recordIterator = records.iterator();
            while (recordIterator.hasNext()) {
                ConsumerRecord<String, String> record = recordIterator.next();
                System.out.printf("topic = %s, key = %s, val = %s \n", record.topic(), record.key(), record.value());
            }
        }

        // 资源关闭
        // consumer.close();
    }

    /**
     * 手动提交
     */
    public static void consumeForCommit() {
        // consumer的配置信息封装
        Properties prop = new Properties();
        prop.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        prop.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        prop.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        prop.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        prop.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "test");

        // 创建consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(prop);

        consumer.subscribe(Collections.singleton(TOPIC_NAME));

        // 轮训处理消息
        while (true) {
            // 拉消息
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            Iterator<ConsumerRecord<String, String>> recordIterator = records.iterator();
            while (recordIterator.hasNext()) {
                ConsumerRecord<String, String> record = recordIterator.next();
                System.out.printf("topic = %s, key = %s, val = %s, offset = %d \n", record.topic(), record.key(), record.value(),
                        record.offset());
            }

            // 手动提交,这里表示的是告诉broker,这个消息我已经正确处理了。
            // 如果业务处理有问题，需要这条消息被继续处理，即被其他consumer来处理。
            // 那么此时就不调用下面这段代码，即未做提交，broker未收到ack,就认为没有被处理，也就是offset也不会向后移动。
            // 所以这条还可以继续被处理和消费。
            consumer.commitAsync();

            // 实际业务场景:
            // 1.收到了消息。需要处理消息内容，封装完成之后，入MySQL。
            // 2.入库时发生失败，MySQL抖动，网络？ 。。。。。 冲突。 需要重试。
            // 3.所以此时，我们判断入库失败，int effectRows == 0, 这个时候不调用consumer.commitAsync();
            // int effectRows = OrderTable.insert(orderDO);
            // if (effectRows > 0){
            //      consumer.commitAsync(); // 入库成功了，业务处理成功了， 此时手动调 提交。
            // }
        }

        // 资源关闭
        // consumer.close();
    }

}
