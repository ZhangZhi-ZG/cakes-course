package course.kafka.consumer;

import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void testAutoCommitConsume() { // xxxxx ==> controller|rpc service
        ConsumerOperating.consumeForAutoCommit();
        ConsumerOperating.consumeForAutoCommit();
        ConsumerOperating.consumeForAutoCommit();
        ConsumerOperating.consumeForAutoCommit();
    }

    @Test
    public void testCommitConsume() {
        ConsumerOperating.consumeForCommit();
    }
}
