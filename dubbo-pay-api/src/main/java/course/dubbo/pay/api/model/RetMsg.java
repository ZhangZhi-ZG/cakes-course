package course.dubbo.pay.api.model;

import java.io.Serializable;

public class RetMsg implements Serializable {
    private Integer errNo;
    private String errMsg;

    public RetMsg() {
    }

    private RetMsg(Integer errNo, String errMsg) {
        this.errNo = errNo;
        this.errMsg = errMsg;
    }

    public static RetMsg createSuccessMsg() {
        return new RetMsg(2000, "SUCCESS");
    }

    public static RetMsg createFailedMsg() {
        return new RetMsg(5000, "FAILED");
    }

    public Integer getErrNo() {
        return errNo;
    }

    public void setErrNo(Integer errNo) {
        this.errNo = errNo;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "RetMsg{" +
                "errNo='" + errNo + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
