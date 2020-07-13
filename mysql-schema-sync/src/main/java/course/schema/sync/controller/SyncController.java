package course.schema.sync.controller;

import course.schema.sync.model.*;
import course.schema.sync.service.SyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
@RestController
@RequestMapping("/sync")
public class SyncController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SyncController.class);

    @Autowired
    private SyncService syncService;

    @RequestMapping("/instance")
    public RetMsg doSyncInstance(@RequestParam SyncInstanceRequest syncRequest) {
        LOGGER.info("do sync start. syncInfo = {}", syncRequest);

        try {
            syncRequest.verify();

            syncService.syncInstance(syncRequest);

            return RetMsg.buildSuccess();
        } catch (Exception e) {
            LOGGER.error("do sync failed.", e);
            return RetMsg.buildFailed(e.getMessage());
        }
    }

    @RequestMapping("/database")
    public RetMsg doSyncDatabase(@RequestParam SyncDatabaseRequest syncRequest) {
        LOGGER.info("do sync start. syncInfo = {}", syncRequest);

        try {
            syncRequest.verify();

            syncService.syncDatabase(syncRequest);

            return RetMsg.buildSuccess();
        } catch (Exception e) {
            LOGGER.error("do sync failed.", e);
            return RetMsg.buildFailed(e.getMessage());
        }
    }

    @RequestMapping("/table")
    public RetMsg doSyncTable(@RequestParam SyncTableRequest syncRequest) {
        LOGGER.info("do sync start. syncInfo = {}", syncRequest);

        try {
            // 1.TODO verify

            syncService.syncTable(syncRequest);

            return RetMsg.buildSuccess();
        } catch (Exception e) {
            LOGGER.error("do sync failed.", e);
            return RetMsg.buildFailed(e.getMessage());
        }
    }
}
