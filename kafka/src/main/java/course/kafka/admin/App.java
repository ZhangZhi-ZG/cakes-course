package course.kafka.admin;

import org.apache.kafka.clients.admin.AdminClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class App {

    private static final String TEST_TOPIC_NAME = "hello-kafka";

    @Test
    public void testCreateAdminClient() {
        AdminClient adminClient = BuildAdminClient.createAdminClient();
        assertThat(adminClient).isNotNull();
    }

    @Test
    public void testCreateTopic() throws Exception {
        TopicOperating.createTopic(TEST_TOPIC_NAME);
    }

    @Test
    public void testListTopic() throws Exception {
        TopicOperating.listTopics();
    }

    @Test
    public void testListTopicWithOptions() throws Exception {
        TopicOperating.listTopicsWithOptions();
    }

    @Test
    public void testRemoveTopic() throws Exception {
        TopicOperating.removeTopic("hello-kafka-hahaha");
    }

    @Test
    public void testDescTopic() throws Exception {
        TopicOperating.describeTopic(TEST_TOPIC_NAME);
    }

    @Test
    public void testDescConfig() throws Exception {
        TopicOperating.describeConfig(TEST_TOPIC_NAME);
    }

    @Test
    public void testUpdateTopicPartition() {
        TopicOperating.updateTopicPartition(TEST_TOPIC_NAME, 5);
    }

    @Test
    public void testUpdateTopicConfig() {
        TopicOperating.updateTopicConfig(TEST_TOPIC_NAME);
    }
}
