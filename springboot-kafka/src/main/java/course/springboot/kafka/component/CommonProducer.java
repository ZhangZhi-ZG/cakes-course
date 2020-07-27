package course.springboot.kafka.component;

import lombok.extern.apachecommons.CommonsLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class CommonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMsg(String msg) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(KafkaConst.TOPIC_NAME, msg);

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
