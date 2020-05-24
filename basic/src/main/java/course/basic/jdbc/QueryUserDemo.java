package course.basic.jdbc;

import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.sql.*;
import java.util.List;

public class QueryUserDemo {
    static String URL = "jdbc:mysql://127.0.0.1:3306/learn?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    static String USER_NAME = "root";
    static String PASSWORD = "123456";

    public static void main(String[] args) {
        // List<TbUser> users = queryUsers();
        // for (TbUser user : users) {
        //     System.out.println("user = " + user);
        // }

        // List<TbAccount> accounts = queryAccounts();
        // for (TbAccount account : accounts) {
        //     System.out.println("account = " + account);
        // }

        // 查询多个表时，以上的 queryUser, queryAccount不具有通用性

        String sql = "select * from tb_user";
        List<Object> params = Lists.newArrayList();
        params.add(2);

        List<TbUser> users = query2(sql, params, TbUser.class);
        for (TbUser user : users) {
            System.out.println(user);
        }

        // String sql = "select * from tb_account";
        // List<Object> params = Lists.newArrayList();
        //
        // List<TbAccount> users = query2(sql, params, TbAccount.class);
        // for (TbAccount user : users) {
        //     System.out.println(user);
        // }
    }

    public static List<TbUser> queryUsers() {
        String sql = "select * from tb_user";
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            List<TbUser> users = Lists.newArrayList();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                TbUser user = new TbUser(id, name, age);
                users.add(user);
            }

            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<TbAccount> queryAccounts() {
        String sql = "select * from tb_account";
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            List<TbAccount> accounts = Lists.newArrayList();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String accountName = resultSet.getString("account_name");
                String accountId = resultSet.getString("account_id");

                TbAccount account = new TbAccount(id, accountName, accountId);

                accounts.add(account);
            }

            return accounts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // ----------------------- 以下是基于field的注入值 ---------------------------

    //由于表对象的不同，处理返回值时采用泛型来解决
    //传入sql、sql中的参数--params，以及一个类的实例
    public static <T> List<T> query2(String sql, List<Object> params, Class<T> clazz) {
        //首先创建数据库连接，预编译sql等一系列操作
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            //创建一个List用来存储实例化的表对象
            List<T> results = Lists.newArrayList();
            //循环获取每一行的查询结果
            while (resultSet.next()) {
                //创建一个类的实例，用来接收具体的数据
                T instance = clazz.newInstance();
                //获取表对象的类属性字段，对应数据库中的表字段
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    //根据表字段获取对应的数据
                    Object val = resultSet.getObject(field.getName());
                    if (val instanceof BigInteger) {
                        long value = ((BigInteger) val).longValue();
                        field.setAccessible(true);
                        field.set(instance, value);
                        continue;
                    }
                    //由于类属性被封装为private，这里设置可访问权限
                    field.setAccessible(true);
                    //instance添加数据
                    field.set(instance, val);
                }
                results.add(instance);
            }

            return results;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    // ----------------------- 以下是基于set方法的注入值 ---------------------------

    public static <T> List<T> query(String sql, List<Object> params, Class<T> clazz) {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            List<T> results = Lists.newArrayList();
            while (resultSet.next()) {
                T instance = clazz.newInstance();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    Object val = resultSet.getObject(field.getName());
                    String methodName = genSetMethodName(field.getName());
                    Method method = getMethodByName(methodName, clazz);
                    method.invoke(instance, val);
                }
                results.add(instance);
            }

            return results;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private static String genSetMethodName(String fileName) {
        return "set" + fileName.substring(0, 1).toUpperCase() + fileName.substring(1);
    }

    private static <T> Method getMethodByName(String methodName, Class<T> clazz) {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    // ------ 使用 row mapper形式来做最终的设计解决方案 --------

    interface RowMapper<T> {

        T map(ResultSet resultSet);
    }

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
