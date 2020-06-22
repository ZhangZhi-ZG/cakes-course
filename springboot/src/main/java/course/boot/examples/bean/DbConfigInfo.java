package course.boot.examples.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
@Component
@PropertySource(value = "classpath:db.properties")
@ConfigurationProperties(prefix = "db")
public class DbConfigInfo {
    private String url;
    private String userName;
    private String passwd;
    private String driverClassName;

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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    @Override
    public String toString() {
        return "DbConfigInfo{" +
                "url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", passwd='" + passwd + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                '}';
    }
}
