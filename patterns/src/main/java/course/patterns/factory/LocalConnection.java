package course.patterns.factory;

public class LocalConnection {
    private String url;

    private String userName;

    private String password;

    private String driverClass;

    private String foo1MySQL;

    private String foo2Oracle;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public void setFoo1MySQL(String foo1MySQL) {
        this.foo1MySQL = foo1MySQL;
    }

    public void setFoo2Oracle(String foo2Oracle) {
        this.foo2Oracle = foo2Oracle;
    }

}
