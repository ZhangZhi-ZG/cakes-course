package course.schema.sync.model;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public class RetMsg {
    private Integer retNo;

    private String retMsg;

    private String data;

    public RetMsg() {
    }

    public RetMsg(Integer retNo, String retMsg) {
        this.retNo = retNo;
        this.retMsg = retMsg;
    }

    public RetMsg(Integer retNo, String retMsg, String data) {
        this.retNo = retNo;
        this.retMsg = retMsg;
        this.data = data;
    }

    public static RetMsg buildSuccess() {
        return new RetMsg(2000, "success");
    }

    public static RetMsg buildFailed(String data) {
        return new RetMsg(5000, "failed.", data);
    }

    public Integer getRetNo() {
        return retNo;
    }

    public void setRetNo(Integer retNo) {
        this.retNo = retNo;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
