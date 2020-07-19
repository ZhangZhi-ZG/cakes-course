package course.schema.sync.test;

import course.schema.sync.model.ConnectInfo;
import course.schema.sync.model.SyncTableRequest;
import course.schema.sync.service.SyncService;
import course.schema.sync.service.impl.SyncServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TestSyncTable {

//    @Autowired
//    private SyncService syncService;

    @Test
    public void testSyncTable() {
        SyncTableRequest request = new SyncTableRequest();

        ConnectInfo src = new ConnectInfo();
        src.setUrl("jdbc:mysql://139.219.4.19:3306");
        src.setUserName("root");
        src.setPassword("123456");
        request.setSrcConnectInfo(src);

        ConnectInfo dst = new ConnectInfo();
        dst.setUrl("jdbc:mysql://139.219.4.19:3307");
        dst.setUserName("root");
        dst.setPassword("123456");
        request.setDstConnectInfo(dst);

        request.setDatabaseName("zzhg");
        request.setTableName("tb_user");

        new SyncServiceImpl().syncTable(request);
    }
}
