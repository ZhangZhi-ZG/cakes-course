package course.basic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo4 {
    // static String URL = "jdbc:mysql://127.0.0.1:3306/course";
    static String URL = "jdbc:mysql://127.0.0.1:3306/course?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    static String USER_NAME = "root";
    static String PASSWORD = "123456";

    public static void main(String[] args) {
        // testInsert1();

        testInsert2();

        // testUpdate();

        // insert , update , delete 操作时只有SQL和数据不一样，其他步骤都一样，所以可以归为一类操作
    }

    private static void testInsert1() {
        // 使用中文时，有字符编码问题
        String sql = "insert into `tb_user`(`name`,`age`) values('jim','66')";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // 建立连接
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            // 创建statement 并执行update
            statement = connection.prepareStatement(sql);
            int effectRows = statement.executeUpdate();

            System.out.println("insert effectRows = " + effectRows);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void testInsert2() {
        // 使用中文时，有字符编码问题. TODO : 字符集编码问题需要设置一下
        String sql = "INSERT INTO `tb_user`(`name`,`age`) VALUES(?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // 建立连接
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            // 创建statement 并执行update
            statement = connection.prepareStatement(sql);
            statement.setString(1, "王五");
            statement.setInt(2, 67);
            int effectRows = statement.executeUpdate();

            System.out.println("insert effectRows = " + effectRows);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void testUpdate() {
        // 使用中文时，有字符编码问题
        String sql = "update tb_user set name='haha' where id=6";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // 建立连接
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            // 创建statement 并执行update
            statement = connection.prepareStatement(sql);
            int effectRows = statement.executeUpdate();

            System.out.println("update effectRows = " + effectRows);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
