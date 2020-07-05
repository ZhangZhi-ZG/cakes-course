package course.schema.sync.model;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public class SyncTableRequest {
    private ConnectInfo srcConnectInfo;

    private ConnectInfo dstConnectInfo;

    private String databaseName;

    private String tableName;

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

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    @Override
    public String toString() {
        return "SyncTableRequest{" +
                "srcConnectInfo=" + srcConnectInfo +
                ", dstConnectInfo=" + dstConnectInfo +
                ", databaseName='" + databaseName + '\'' +
                ", tableName='" + tableName + '\'' +
                '}';
    }
}
