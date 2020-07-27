package course.kafka.test;

public class Order {

    private String orderId;

    private String info;

    public String getOrderId() {
        // NODE: 创建订单: 用户信息获取 : bbbbb
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
