package course.basic.oop;

/**
 * setter & getter
 *
 * @author cbooy
 * @date 2020-05-01
 */
// Order.class
public class Order {

  private Long amount;

  private String payeeUserId;

  private String payerUserId;

  public Order() {
    //System.out.println("Order.Order 被创建了?");
    // 开辟空间之后，拿到一个地址假设是0x1122
    // this = 0x1122;
  }

  public Order(Long amount) {
    this.amount = amount;
  }

  public Order(Long amount, String payeeUserId) {
    // this = 0X112233
    this.amount = amount;
    this.payeeUserId = payeeUserId;
  }

  public Order(Long amount, String payeeUserId, String payerUserId) {
    // this = 地址
    // 常用方式
//    this.amount = amount;
//    this.payeeUserId = payeeUserId;
//    this.payerUserId = payerUserId;

    this(amount, payeeUserId);
    this.payerUserId = payerUserId;
  }

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public String getPayeeUserId() {
    return payeeUserId;
  }

  public void setPayeeUserId(String payeeUserId) {
    this.payeeUserId = payeeUserId;
  }

  public String getPayerUserId() {
    return payerUserId;
  }

  public void setPayerUserId(String payerUserId) {
    this.payerUserId = payerUserId;
  }
}
