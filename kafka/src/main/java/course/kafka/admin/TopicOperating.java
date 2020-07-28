package course.kafka.admin;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.config.ConfigResource;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Topic 操作
 * 最基本的操作包括:
 * - 创建
 * - 删除
 * - 配置
 * - 描述
 */
public class TopicOperating {

    /**
     * 创建Topic
     *
     * @param topicName
     */
    public static void createTopic(String topicName) throws Exception {
        AdminClient adminClient = BuildAdminClient.createAdminClient();

        /**
         * String name       topic名字
         * int numPartitions  分区数
         * short replicationFactor 副本数,必须不能大于broker熟练
         */
        NewTopic topic = new NewTopic(topicName, 1, Short.parseShort("1"));

        CreateTopicsResult result = adminClient.createTopics(Collections.singletonList(topic));

        // 这里是为什么这样搞???
        result.all().get();

        result.values().forEach((name, future) -> {
            System.out.println("TopicOperating.createTopic name = " + name);
        });

        // 资源关闭.
        adminClient.close();
    }

    /**
     * 列出所有的topic
     *
     * @throws Exception
     */
    public static void listTopics() throws Exception {
        AdminClient adminClient = BuildAdminClient.createAdminClient();

        // 列出所有的topic
        ListTopicsResult result = adminClient.listTopics();

        // 解析获取结果
        Set<String> names = result.names().get();
        for (String name : names) {
            System.out.println("topic name = " + name);
        }

        System.out.println("=======\n");

        Collection<TopicListing> listings = result.listings().get();
        for (TopicListing listing : listings) {
            System.out.println("listing = " + listing);
        }
        // 资源关闭.
        adminClient.close();
    }

    /**
     * 列出所有的topic
     *
     * @throws Exception
     */
    public static void listTopicsWithOptions() throws Exception {
        AdminClient adminClient = BuildAdminClient.createAdminClient();

        ListTopicsOptions options = new ListTopicsOptions();
        options.listInternal(true);

        // 列出所有的topic
        ListTopicsResult result = adminClient.listTopics(options);

        // 解析获取结果
        Set<String> names = result.names().get();
        for (String name : names) {
            System.out.println("topic name = " + name);
        }

        System.out.println("=======\n");

        Collection<TopicListing> listings = result.listings().get();
        for (TopicListing listing : listings) {
            System.out.println("listing = " + listing);
        }
        // 资源关闭.
        adminClient.close();
    }

    /**
     * 删除topic
     *
     * @param topicName
     * @throws Exception
     */
    public static void removeTopic(String topicName) throws Exception {
        AdminClient adminClient = BuildAdminClient.createAdminClient();

        // 为啥提供的api是可以删除多个,而不是一个个的删除，并且都没有给提供一个个删除的接口 ???
        DeleteTopicsResult result = adminClient.deleteTopics(Collections.singletonList(topicName));

        // 妹的 这玩意有啥用 ???
        KafkaFuture<Void> kafkaFuture = result.all();
        Void val = kafkaFuture.get();

        // 资源关闭.
        adminClient.close();
    }

    /**
     * 获取指定topic的描述信息
     * <p>
     * topic name = hello-kafka,
     * desc =
     * (
     * name=hello-kafka,
     * internal=false,
     * partitions=(
     * partition=0, leader=127.0.0.1:9092 (id: 0 rack: null
     * ),
     * replicas=127.0.0.1:9092 (id: 0 rack: null),
     * isr=127.0.0.1:9092 (id: 0 rack: null)),
     * authorizedOperations=null
     * )
     * <p>
     * -----------
     * <p>
     * topic name = hello-kafka,
     * desc = (name=hello-kafka, internal=false,
     * partitions=(
     * partition=0, leader=127.0.0.1:9092 (id: 0 rack: null), replicas=127.0.0.1:9092 (id: 0 rack: null), isr=127.0.0.1:9092 (id: 0 rack: null)),
     * (partition=1, leader=127.0.0.1:9092 (id: 0 rack: null), replicas=127.0.0.1:9092 (id: 0 rack: null), isr=127.0.0.1:9092 (id: 0 rack: null)),
     * authorizedOperations=null)
     *
     * @param topicName
     */
    public static void describeTopic(String topicName) throws Exception {
        AdminClient adminClient = BuildAdminClient.createAdminClient();

        // 获取Topic的描述信息
        DescribeTopicsResult result = adminClient.describeTopics(Collections.singletonList(topicName));

        // 解析描述信息结果, Map<String, TopicDescription> ==> topicName:TopicDescription
        Map<String, TopicDescription> descriptionMap = result.all().get();
        descriptionMap.forEach((name, desc) -> System.out.printf("topic name = %s, desc = %s \n", name, desc));

        // 资源关闭.
        adminClient.close();
    }

    /**
     * 获取 topic的配置描述信息
     * <p>
     * ConfigResource = ConfigResource(type=TOPIC, name='hello-kafka'),
     * Config = Config(
     * entries=[
     * ConfigEntry(name=compression.type, value=producer, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=leader.replication.throttled.replicas, value=, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=message.downconversion.enable, value=true, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=min.insync.replicas, value=1, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=segment.jitter.ms, value=0, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=cleanup.policy, value=delete, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=flush.ms, value=9223372036854775807, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=follower.replication.throttled.replicas, value=, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=segment.bytes, value=1073741824, source=STATIC_BROKER_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=retention.ms, value=604800000, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=flush.messages, value=9223372036854775807, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=message.format.version, value=2.5-IV0, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=max.compaction.lag.ms, value=9223372036854775807, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=file.delete.delay.ms, value=60000, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=max.message.bytes, value=1048588, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=min.compaction.lag.ms, value=0, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=message.timestamp.type, value=CreateTime, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=preallocate, value=false, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=min.cleanable.dirty.ratio, value=0.5, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=index.interval.bytes, value=4096, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=unclean.leader.election.enable, value=false, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=retention.bytes, value=-1, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=delete.retention.ms, value=86400000, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=segment.ms, value=604800000, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=message.timestamp.difference.max.ms, value=9223372036854775807, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[]),
     * ConfigEntry(name=segment.index.bytes, value=10485760, source=DEFAULT_CONFIG, isSensitive=false, isReadOnly=false, synonyms=[])])
     *
     * @param topicName
     * @throws Exception
     */
    @Test
    public static void describeConfig(String topicName) throws Exception {
        AdminClient adminClient = BuildAdminClient.createAdminClient();

        ConfigResource configResource = new ConfigResource(ConfigResource.Type.TOPIC, topicName);

        DescribeConfigsResult result = adminClient.describeConfigs(Collections.singletonList(configResource));

        Map<ConfigResource, Config> resourceConfigMap = result.all().get();
        resourceConfigMap.forEach((cr, c) -> {
            System.out.printf("desc topic config ConfigResource = %s, Config = %s \n", cr, c);
        });

        // 资源关闭.
        adminClient.close();
    }

    /**
     * 修改topic的分区数量,注意： 只能加不能减
     *
     * @param topicName
     * @param partitionNum
     */
    public static void updateTopicPartition(String topicName, int partitionNum) {
        AdminClient adminClient = BuildAdminClient.createAdminClient();

        // 构建修改分区的topic请求参数
        Map<String, NewPartitions> newPartitions = Maps.newHashMap();
        newPartitions.put(topicName, NewPartitions.increaseTo(partitionNum));

        // 执行修改
        adminClient.createPartitions(newPartitions);

        // 资源关闭.
        adminClient.close();
    }

    public static void updateTopicConfig(String topicName) {
        AdminClient adminClient = BuildAdminClient.createAdminClient();

        Map<ConfigResource, Config> configMap = Maps.newHashMap();

        ConfigResource configResource = new ConfigResource(ConfigResource.Type.TOPIC, topicName);
        Config config = new Config(Collections.singletonList(new ConfigEntry("preallocate", "true")));

        configMap.put(configResource, config);

        // 修改topic 配置,用的是老api,已经过时
        adminClient.alterConfigs(configMap);

        // 下面这个是新api.但是有些麻烦
        // adminClient.incrementalAlterConfigs();

        // 资源关闭.
        adminClient.close();
    }
}
