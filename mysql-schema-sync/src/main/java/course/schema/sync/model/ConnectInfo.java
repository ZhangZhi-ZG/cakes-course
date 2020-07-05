package course.schema.sync.model;

import course.schema.sync.util.VerifyUtils;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public class ConnectInfo {
    private String url;
    private String userName;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void verify() {
        // 第一种.判断
        VerifyUtils.requiredNotNullOrEmpty(this.url, "url should not be null");
        VerifyUtils.requiredNotNullOrEmpty(this.userName, "username should not be null");
        VerifyUtils.requiredNotNullOrEmpty(this.password, "password should not be null");

        // 第二种判断
//        VerifyUtils.requiredAllNotNullOrEmpty(this.url, this.userName, this.password);
    }

    @Override
    public String toString() {
        return "ConnectInfo{" +
                "url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
