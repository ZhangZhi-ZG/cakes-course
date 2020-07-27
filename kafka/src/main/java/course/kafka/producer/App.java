package course.kafka.producer;

import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void testSimpleSend() {
        ProducerOperating.sendMsg("hello", "test kafka");
    }

    @Test
    public void testMultipleSend() {
        ProducerOperating.sendMultipleMsg("test", "send kafka msg");
    }

    @Test
    public void testSyncSend() throws Exception {
//        ProducerOperating.sendMultipleMsg("test", "send kafka msg");
        ProducerOperating.sendMsgWithSync("test", "send kafka msg");
    }

    @Test
    public void testSendWithCallback() throws Exception {
        ProducerOperating.sendMsgWithCallback("test", "hello kafka");
    }

    @Test
    public void testSendWithPartition() throws Exception {
        ProducerOperating.sendMsgWithPartition("takeaway_xyz", "hello kafka");
    }

    @Test
    public void testSendSingleMsgForSync() throws Exception {
        ProducerOperating.sendSingleMsgForSync("hello", "test kafka");
    }
}
