package course.patterns.factory;

public class LocalConnectionApp {

    public static void main(String[] args) {
        LocalConnection localConnection = new LocalConnection();
        localConnection.setUrl("");
        localConnection.setDriverClass("");
        localConnection.setFoo1MySQL("");
        localConnection.setUserName("");
    }

}
