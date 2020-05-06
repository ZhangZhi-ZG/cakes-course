package course.basic.oop;

/**
 * setter & getter
 *
 * @author cbooy
 * @date 2020-05-01
 */
// Order.class
public class Order {
    /**
     * 权限修饰符
     * private：私有的，实例化对象及继承对象无法直接调用--建议使用private来修饰变量
     * public：公共的，可以被调用
     * protected：受保护的，继承后可以被调用
     */
    //private权限修饰符-实例化对象及其它类无法调用被修饰的变量
    private Long amount;

    private String payeeUserId;

    private String payerUserId;

    /**
     * 构造方法：
     * 可以有一个或者多个参数
     */
    public Order() {
    }

    public Order(Long amount) {
        this.amount = amount;
    }

    public Order(Long amount, String payeeUserId) {
        this.amount = amount;
        this.payeeUserId = payeeUserId;
    }

    public Order(Long amount, String payeeUserId, String payerUserId) {
        this(amount,payeeUserId);
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
