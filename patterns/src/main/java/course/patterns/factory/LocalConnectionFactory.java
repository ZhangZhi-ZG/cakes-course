package course.patterns.factory;

public class LocalConnectionFactory {
    public static LocalConnection createMySQLConnection(String url, String userName, String passwd) {
        LocalConnection connection = new LocalConnection();
        connection.setFoo1MySQL("mysql");
        connection.setDriverClass("org.gjt.mm.mysql.Driver");
        return connection;
    }

    public static LocalConnection createOracleConnection(String url, String userName, String passwd) {
        LocalConnection connection = new LocalConnection();
        connection.setFoo1MySQL("oracle");
        connection.setDriverClass("xxx.oracle.Driver");
        return connection;
    }

    public static void main(String[] args) {
        LocalConnectionFactory.createMySQLConnection("", "", "");
        LocalConnectionFactory.createOracleConnection("", "", "");
    }
}
