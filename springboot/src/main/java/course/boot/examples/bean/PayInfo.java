package course.boot.examples.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
@Component
@ConfigurationProperties(prefix = "pay")
public class PayInfo {
    private String orderId;
    private String payId;
    private Integer amount;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
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
                "orderId='" + orderId + '\'' +
                ", payId='" + payId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
