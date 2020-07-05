package course.schema.sync.model;

import course.schema.sync.util.VerifyUtils;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public class SyncDatabaseRequest {

    private ConnectInfo srcConnectInfo;

    private ConnectInfo dstConnectInfo;

    private String instanceName;

    private String databaseName;

    public ConnectInfo getSrcConnectInfo() {
        return srcConnectInfo;
    }

    public void setSrcConnectInfo(ConnectInfo srcConnectInfo) {
        this.srcConnectInfo = srcConnectInfo;
    }

    public ConnectInfo getDstConnectInfo() {
        return dstConnectInfo;
    }

    public void setDstConnectInfo(ConnectInfo dstConnectInfo) {
        this.dstConnectInfo = dstConnectInfo;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public void verify() {
        this.srcConnectInfo.verify();
        this.dstConnectInfo.verify();
        VerifyUtils.requiredNotNullOrEmpty(this.instanceName, "sync instance name should not be null or empty");
        VerifyUtils.requiredNotNullOrEmpty(this.databaseName, "sync database name should not be null or empty");
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    @Override
    public String toString() {
        return "SyncDatabaseRequest{" +
                "srcConnectInfo=" + srcConnectInfo +
                ", dstConnectInfo=" + dstConnectInfo +
                ", instanceName='" + instanceName + '\'' +
                ", databaseName='" + databaseName + '\'' +
                '}';
    }
}
