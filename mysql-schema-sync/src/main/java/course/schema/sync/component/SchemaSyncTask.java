package course.schema.sync.component;

import course.schema.sync.model.SyncDatabaseRequest;
import course.schema.sync.model.SyncInstanceRequest;
import course.schema.sync.model.SyncTableRequest;
import course.schema.sync.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * author: heiha
 */
@Component
public class SchemaSyncTask {

    @Autowired
    private SyncService syncService;

    @Scheduled(cron = "*/30 * * * * *")
    public void doSyncTable() {
        // 0.来个线程池，每一次同步，都新搞个线程去run.
        // 1.加载数据，用mapper取出所有 配置了同步表的记录行。 status==0.需要去做同步的，status==1,这个时效，不做了

        // 2.获取一堆配置。List<SyncTableDO>

        // 3.循环处理
        // for List<SyncTableDO> == > SyncTableRequest
        // for syncService.syncTable(new SyncTableRequest());
        syncService.syncTable(new SyncTableRequest());
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void doSyncDatabase() {
        syncService.syncDatabase(new SyncDatabaseRequest());
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void doSyncInstance() {
        syncService.syncInstance(new SyncInstanceRequest());
    }
}
