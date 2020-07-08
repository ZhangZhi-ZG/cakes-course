package course.patterns.bean;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class Tickets {
    private Integer amount;
    private String src;
    private String dst;

    public Tickets() {
    }

    public Tickets(Integer amount, String src, String dst) {
        this.amount = amount;
        this.src = src;
        this.dst = dst;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "amount=" + amount +
                ", src='" + src + '\'' +
                ", dst='" + dst + '\'' +
                '}';
    }
}
