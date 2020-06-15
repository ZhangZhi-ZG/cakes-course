package course.basic.assignment.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zzhg
 * @date 2020-05-23
 */
public final class myConn {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/learn?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWD = "123456";

    private Connection conn;

    private myConn(){
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static class ClassHolder{
        private static final myConn INSTANCE = new myConn();
    }

    public static myConn of(){
        return ClassHolder.INSTANCE;
    }

    public void updateData(String sql, List<Object> params){
        PreparedStatement statement = null;

        try {
            statement = this.conn.prepareStatement(sql);

            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i+1,params.get(i));
            }

            int row = statement.executeUpdate();
            System.out.println("受影响的行数 = " + row);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (this.conn !=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
