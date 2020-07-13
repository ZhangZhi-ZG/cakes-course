package course.schema.sync.service;

import course.schema.sync.model.SyncDatabaseRequest;
import course.schema.sync.model.SyncInstanceRequest;
import course.schema.sync.model.SyncTableRequest;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public interface SyncService {

    void syncInstance(SyncInstanceRequest syncInfo);

    void syncDatabase(SyncDatabaseRequest syncInfo);

    void syncTable(SyncTableRequest syncInfo);
}
