package course.basic.jdbc;

import com.google.common.collect.Lists;

import java.sql.*;
import java.util.List;

public class QueryUserDemo2 {
    static String URL = "jdbc:mysql://127.0.0.1:3306/course?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    static String USER_NAME = "root";
    static String PASSWORD = "123456";

    public static void main(String[] args) {
//         String sql = "select * from tb_user where id>?";
//         List<Object> params = Lists.newArrayList();
//         params.add(2);
//
//         List<TbUser> users = queryForMapper(sql, params, new RowMapper<TbUser>() {
//             @Override
//             public TbUser map(ResultSet resultSet) throws SQLException {
//                 long id = resultSet.getLong("id");
//                 String name = resultSet.getString("name");
//                 int age = resultSet.getInt("age");
//                 return new TbUser(id, name, age);
//             }
//         });
//
//
//         for (TbUser user : users) {
//             System.out.println(user);
//         }

        String sql = "select * from tb_account where id>?";
        List<Object> params = Lists.newArrayList();
        params.add(0);

        List<TbAccount> users = queryForMapper(sql, params, new AccountMapper());
        for (TbAccount user : users) {
            System.out.println(user);
        }


    }


    //根据具体的表来实现map方法
    static class AccountMapper implements RowMapper<TbAccount> {
        @Override
        public TbAccount map(ResultSet resultSet) throws SQLException {
            long id = resultSet.getLong("id");
            String accountName = resultSet.getString("account_name");
            String accountId = resultSet.getString("account_id");
            return new TbAccount(id, accountName, accountId);
        }
    }

    //首先抽象一个RowMapper接口
    interface RowMapper<T> {
        //定义一个map方法
        T map(ResultSet resultSet) throws SQLException;
    }

    // 模板设计模式
    //虽然利用的Java的反射机制也可以解决，但是还需要自己对字段类型进行处理，为了避免麻烦，采用另外一种更为简洁的方式--mapper
    //传入sql、sql中的参数-params，以及一个mapper对象
    public static <T> List<T> queryForMapper(String sql, List<Object> params, RowMapper<T> mapper) {
        //由于sql中有参数需要处理，所以将connection、statement等变量单独领出来定义
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            //根据params的个数，来对sql进行赋值
            for (int i = 0; i < params.size(); i++) {
                //注意：赋值时，索引从1开始
                statement.setObject(i + 1, params.get(i));
            }
            //执行查询，获取结果集
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
