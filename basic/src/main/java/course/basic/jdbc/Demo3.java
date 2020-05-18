package course.basic.jdbc;

import java.sql.*;

/**
 * jdbc 第一个示例，读取数据
 */
public class Demo3 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/course";
        String userName = "root";
        String password = "123456";
        String sql = "select id ,name ,age from tb_user;";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // 1.建立连接
            connection = DriverManager.getConnection(url, userName, password);

            // 2.具体操作
            // 2.1 预编译 SQL
            statement = connection.prepareStatement(sql);
            // 2.2 执行查询
            resultSet = statement.executeQuery();
            // 2.3 处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                // 不建议使用
                // int id2 = resultSet.getInt(1);
                // System.out.println("id2="+id2);
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("id = " + id + ", name=" + name + ", age=" + age);
            }

        } catch (SQLException e) {
            e.printStackTrace();// 不推荐的异常处理方式
        } finally {
            // 3.资源关闭
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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
