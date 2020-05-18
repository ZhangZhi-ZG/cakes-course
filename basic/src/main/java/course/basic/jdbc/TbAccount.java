package course.basic.jdbc;

public class TbAccount {
    private Long id;
    private String accountName;
    private String accountId;

    public TbAccount() {
    }

    public TbAccount(Long id, String accountName, String accountId) {
        this.id = id;
        this.accountName = accountName;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "TbAccount{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}
