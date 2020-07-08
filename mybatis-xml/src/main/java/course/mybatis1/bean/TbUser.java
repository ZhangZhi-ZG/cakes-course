package course.mybatis1.bean;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class TbUser {
    private Long id;
    private String userId;
    private String userName;

    public TbUser() {
    }

    public TbUser(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "TbUser{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
