package course.auto.framework.cases.model;

public class NewOrder {

    private String orderId;
    private NewUser payer;
    private NewUser payee;
    private Long amount;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public NewUser getPayer() {
        return payer;
    }

    public void setPayer(NewUser payer) {
        this.payer = payer;
    }

    public NewUser getPayee() {
        return payee;
    }

    public void setPayee(NewUser payee) {
        this.payee = payee;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "NewOrder{" +
                "orderId='" + orderId + '\'' +
                ", payer=" + payer +
                ", payee=" + payee +
                ", amount=" + amount +
                '}';
    }
}
