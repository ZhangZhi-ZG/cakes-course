package course.kafka.producer;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

public class SimplePartitioner implements Partitioner {

    /**
     * 0-4 个分区
     * <p>
     * 演示下自定义消息发送至指定分区的逻辑而已。
     * <p>
     * 真实业务要比这复杂很多的
     *
     * @param topic
     * @param key
     * @param keyBytes
     * @param value
     * @param valueBytes
     * @param cluster
     * @return
     */
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        // topic = hello-kafka
        // key = takeaway  0-3
        // key = hotel  4
        if (StringUtils.startsWith(key.toString(), "takeaway_")) {
            int code = Math.abs(key.toString().hashCode());
            return code % 4;
        }

        return 4;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
