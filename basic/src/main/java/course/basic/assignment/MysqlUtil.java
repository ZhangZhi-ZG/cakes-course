package course.basic.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author zzhg
 * @date 2020-05-13
 */
public class MysqlUtil {

    static private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static private final String DB_URL = "jdbc:mysql://localhost:3306/learn?useSSL=false&serverTimezone=UTC";
    static private final String USER = "root";
    static private final String PASSWD = "123456";

    public MysqlUtil() {


    }

    public Connection myConn(){
        Connection conn = null;
        try {
            //1、加载驱动
            Class.forName(JDBC_DRIVER);
            //2、建立数据库连接
            conn = DriverManager.getConnection(DB_URL, USER, PASSWD);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public PreparedStatement updateData(Connection conn, String sql){
        PreparedStatement psql = null;
        try {
            psql = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return psql;
    }

    public void closeConn(Connection conn,PreparedStatement psql){
        try {
            //6、关闭数据库连接
            conn.close();
            psql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
