package course.basic.jdbc;

import java.sql.*;

/**
 * jdbc 第一个示例，读取数据
 */
public class Demo2 {

    public static void main(String[] args) throws SQLException {
        // 不用关心
        // http://
        // https://
        // tcp://
        // dubbo://
        String url = "jdbc:mysql://127.0.0.1:3306/course";
        String userName = "root";
        String password = "123456";
        String sql = "select id as i,name as n,age as a from tb_user;";

        // 1.建立连接
        Connection connection = DriverManager.getConnection(url, userName, password);

        // 2.具体操作
        // 2.1 预编译 SQL
        PreparedStatement statement = connection.prepareStatement(sql);
        // 2.2 执行查询
        ResultSet resultSet = statement.executeQuery();
        // 2.3 处理结果集
        while (resultSet.next()) {
            int id = resultSet.getInt("i");
            // 不建议使用
            // int id2 = resultSet.getInt(1);
            // System.out.println("id2="+id2);
            String name = resultSet.getString("n");
            int age = resultSet.getInt("a");
            System.out.println("id = " + id + ", name=" + name + ", age=" + age);
        }

        // 3.资源关闭
        resultSet.close();
        statement.close();
        connection.close();
    }

}
