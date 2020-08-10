package course.kafka.admin;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;

import java.util.Properties;

/**
 * 创建AdminClient, 创建时指定相应的配置，目前最简化给出kafka broker地址即可
 * <p>
 * bootstrap.servers = 127.0.0.1:9092
 */
public class BuildAdminClient {

    public static AdminClient createAdminClient() {
        Properties props = new Properties();

        props.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "139.219.4.19:9092");

        return AdminClient.create(props);
    }
}
