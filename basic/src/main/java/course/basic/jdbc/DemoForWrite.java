package course.basic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DemoForWrite {
    static String URL = "jdbc:mysql://127.0.0.1:3306/course";
    static String USER_NAME = "root";
    static String PASSWORD = "123456";

    public static int modify(String sql, List<Object> params) {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

             /**

              String sql = "update tb_user set name=?,age=? where id=?";
              List<Object> params = Lists.newArrayList();
              params.add("hehehehe");
              params.add(67);
              params.add(5);

              */
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i));
            }

            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
