package course.schema.sync.test;

import course.schema.sync.model.ConnectInfo;
import course.schema.sync.model.SyncDatabaseRequest;
import course.schema.sync.service.impl.SyncServiceImpl;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * author: heiha
 */
public class TestSyncDatabase {

    @Test
    public void testSyncDatabase() {
        SyncDatabaseRequest request = new SyncDatabaseRequest();

        ConnectInfo src = new ConnectInfo();
        // jdbc:mysql://127.0.0.1:3306 ? &characterEncoding=utf-8
        // jdbc:mysql://127.0.0.1:3306 ? useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC
        src.setUrl("jdbc:mysql://127.0.0.1:3306?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        src.setUserName("root");
        src.setPassword("123456");
        request.setSrcConnectInfo(src);

        ConnectInfo dst = new ConnectInfo();
        dst.setUrl("jdbc:mysql://127.0.0.1:3388?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        dst.setUserName("root");
        dst.setPassword("123456");
        request.setDstConnectInfo(dst);
        request.setSrcConnectInfo(src);
        request.setDstConnectInfo(dst);

        request.setDatabaseName("course");

        request.setExcludeTables(Lists.newArrayList("user"));

        new SyncServiceImpl().syncDatabase(request);
    }
}
