package course.schema.sync.model;

import java.util.List;
import java.util.Map;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public class SyncInstanceRequest {
    private ConnectInfo srcConnectInfo;

    private ConnectInfo dstConnectInfo;

    private List<String> excludeDatabases;

    //
    private Map<String, List<String>> excludeTables;

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

    public List<String> getExcludeDatabases() {
        return excludeDatabases;
    }

    public void setExcludeDatabases(List<String> excludeDatabases) {
        this.excludeDatabases = excludeDatabases;
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
                ", excludeDatabases=" + excludeDatabases +
                '}';
    }
}
