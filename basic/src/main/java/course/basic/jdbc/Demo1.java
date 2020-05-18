package course.basic.jdbc;

import java.sql.*;

public class Demo1 {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/students";
        String userName = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement statement = connection.prepareStatement("select * from tb_user");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println("name=" + name + ", age=" + age);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
