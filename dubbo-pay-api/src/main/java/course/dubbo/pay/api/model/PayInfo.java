package course.dubbo.pay.api.model;

import java.io.Serializable;

public class PayInfo implements Serializable {

    private String transId;

    private Integer amount;

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PayInfo{" +
                "transId='" + transId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
