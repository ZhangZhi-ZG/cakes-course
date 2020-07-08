package course.boot.mybatis.bean;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class UserDTO {
    private String userId;
    private String userName;

    public UserDTO() {
    }

    public UserDTO(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
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
}
