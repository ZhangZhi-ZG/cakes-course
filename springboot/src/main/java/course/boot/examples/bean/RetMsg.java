package course.boot.examples.bean;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
public class RetMsg {
    private static final int SUCCESS_NO = 2000;
    private static final String SUCCESS_MSG = "success";

    private static final int ERROR_NO = 5000;
    private static final String ERROR_MSG = "failed";

    private Integer errNo;
    private String errMsg;
    private String data;

    public RetMsg() {
    }

    public RetMsg(Integer errNo, String errMsg) {
        this.errNo = errNo;
        this.errMsg = errMsg;
    }

    public RetMsg(Integer errNo, String errMsg, String data) {
        this.errNo = errNo;
        this.errMsg = errMsg;
        this.data = data;
    }

    public static RetMsg buildSuccessMsg(String data) {
        return new RetMsg(SUCCESS_NO, SUCCESS_MSG, data);
    }

    public static RetMsg buildFailedMsg(String msg) {
        return new RetMsg(ERROR_NO, msg);
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
