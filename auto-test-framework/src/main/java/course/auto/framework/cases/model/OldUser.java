package course.auto.framework.cases.model;

public class OldUser {
    private String userId;

    public OldUser() {
    }

    public OldUser(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "OldUser{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
