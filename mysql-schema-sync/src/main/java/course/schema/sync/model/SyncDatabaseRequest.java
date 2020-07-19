package course.schema.sync.model;

import course.schema.sync.util.VerifyUtils;

import java.util.List;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public class SyncDatabaseRequest {
    private ConnectInfo srcConnectInfo;

    private ConnectInfo dstConnectInfo;

    private String databaseName;

    private List<String> excludeTables;

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

    public List<String> getExcludeTables() {
        return excludeTables;
    }

    public void setExcludeTables(List<String> excludeTables) {
        this.excludeTables = excludeTables;
    }

    public void verify() {
        this.srcConnectInfo.verify();
        this.dstConnectInfo.verify();
        VerifyUtils.requiredNotNullOrEmpty(this.databaseName, "sync database name should not be null or empty");
    }

    @Override
    public String toString() {
        return "SyncDatabaseRequest{" +
                "srcConnectInfo=" + srcConnectInfo +
                ", dstConnectInfo=" + dstConnectInfo +
                ", databaseName='" + databaseName + '\'' +
                ", excludeTables='" + excludeTables + '\'' +
                '}';
    }
}
