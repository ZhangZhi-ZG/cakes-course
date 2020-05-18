package course.basic.jdbc;

import com.google.common.collect.Lists;

import java.sql.*;
import java.util.List;

public class QueryUserDemo2 {
    static String URL = "jdbc:mysql://127.0.0.1:3306/course?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    static String USER_NAME = "root";
    static String PASSWORD = "123456";

    public static void main(String[] args) {
        // String sql = "select * from tb_user where id>?";
        // List<Object> params = Lists.newArrayList();
        // params.add(2);
        //
        // List<TbUser> users = queryForMapper(sql, params, new RowMapper<TbUser>() {
        //     @Override
        //     public TbUser map(ResultSet resultSet) throws SQLException {
        //         long id = resultSet.getLong("id");
        //         String name = resultSet.getString("name");
        //         int age = resultSet.getInt("age");
        //         return new TbUser(id, name, age);
        //     }
        // });
        //
        //
        // for (TbUser user : users) {
        //     System.out.println(user);
        // }

        String sql = "select * from tb_account where id>?";
        List<Object> params = Lists.newArrayList();
        params.add(0);

        List<TbAccount> users = queryForMapper(sql, params, new AccountMapper());
        for (TbAccount user : users) {
            System.out.println(user);
        }
    }

    static class AccountMapper implements RowMapper<TbAccount> {
        @Override
        public TbAccount map(ResultSet resultSet) throws SQLException {
            long id = resultSet.getLong("id");
            String accountName = resultSet.getString("account_name");
            String accountId = resultSet.getString("account_id");
            return new TbAccount(id, accountName, accountId);
        }
    }


    interface RowMapper<T> {

        T map(ResultSet resultSet) throws SQLException;
    }

    // 模板设计模式
    public static <T> List<T> queryForMapper(String sql, List<Object> params, RowMapper<T> mapper) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i));
            }

            resultSet = statement.executeQuery();

            List<T> results = Lists.newArrayList();

            while (resultSet.next()) {
                // 这里是个抽象点 -> 一提到抽象 立马想到 接口
                T obj = mapper.map(resultSet);
                results.add(obj);
            }

            return results;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
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
