package course.schema.sync.model;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public class SyncInstanceRequest {
    private ConnectInfo srcConnectInfo;

    private ConnectInfo dstConnectInfo;

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

    public void verify() {
        this.srcConnectInfo.verify();

        this.dstConnectInfo.verify();
    }

    @Override
    public String toString() {
        return "SyncInstanceRequest{" +
                "srcConnectInfo=" + srcConnectInfo +
                ", dstConnectInfo=" + dstConnectInfo +
                '}';
    }
}
