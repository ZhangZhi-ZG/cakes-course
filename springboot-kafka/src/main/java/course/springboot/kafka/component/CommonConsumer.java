package course.springboot.kafka.component;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonConsumer.class);

    @KafkaListener(topics = KafkaConst.TOPIC_NAME, groupId = KafkaConst.GROUP_ONE)
    public void consumeGroupOne(ConsumerRecord<String, String> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional<String> msgOptional = Optional.ofNullable(record.value());
        if (msgOptional.isPresent()) {
            Object msg = msgOptional.get();
            LOGGER.info("group one start: topic={}, msg={}", topic, msg);
            ack.acknowledge();
        }
    }

    @KafkaListener(topics = KafkaConst.TOPIC_NAME, groupId = KafkaConst.GROUP_TWO)
    public void consumeGroupTwo(ConsumerRecord<String, String> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional<String> msgOptional = Optional.ofNullable(record.value());
        if (msgOptional.isPresent()) {
            Object msg = msgOptional.get();
            LOGGER.info("group two start: topic={}, msg={}", topic, msg);
            ack.acknowledge();
        }
    }
}
