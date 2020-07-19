package course.schema.sync.test;

import com.google.gson.Gson;
import course.schema.sync.model.ConnectInfo;
import course.schema.sync.model.SyncInstanceRequest;
import course.schema.sync.service.impl.SyncServiceImpl;
import org.junit.Test;

/**
 * author: heiha
 */
public class TestSyncInstance {

    @Test
    public void testJson() {
        SyncInstanceRequest request = new SyncInstanceRequest();

        ConnectInfo src = new ConnectInfo();
        src.setUrl("jdbc:mysql://127.0.0.1:3306?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        src.setUserName("root");
        src.setPassword("123456");
        request.setSrcConnectInfo(src);

        ConnectInfo dst = new ConnectInfo();
        dst.setUrl("jdbc:mysql://127.0.0.1:3388?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        dst.setUserName("root");
        dst.setPassword("123456");
        request.setDstConnectInfo(dst);

        String val = new Gson().toJson(request);

        System.out.println("val = " + val);
    }

    @Test
    public void testSync() {
        SyncInstanceRequest request = new SyncInstanceRequest();

        ConnectInfo src = new ConnectInfo();
        src.setUrl("jdbc:mysql://127.0.0.1:3306?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        src.setUserName("root");
        src.setPassword("123456");
        request.setSrcConnectInfo(src);

        ConnectInfo dst = new ConnectInfo();
        dst.setUrl("jdbc:mysql://127.0.0.1:3388?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        dst.setUserName("root");
        dst.setPassword("123456");
        request.setDstConnectInfo(dst);

        new SyncServiceImpl().syncInstance(request);
    }
}
