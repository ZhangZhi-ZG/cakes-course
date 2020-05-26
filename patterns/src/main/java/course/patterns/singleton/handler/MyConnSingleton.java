package course.patterns.singleton.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author zzhg
 * @date 2020-05-25
 */
public class MyConnSingleton {
    private Connection conn;


    private MyConnSingleton() {
        try {
            System.out.println("MyConnSingleton.MyConnSingleton");
            String username = "root";
            String url = "jdbc:mysql://127.0.0.1:3306/learn?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
            String passwd = "123456";
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static class ClassHolder {
        private static final MyConnSingleton INSTANCE = new MyConnSingleton();
    }

    public static MyConnSingleton of() {
        System.out.println("MyConnSingleton.of");
        return ClassHolder.INSTANCE;
    }

    public static void foo1(Integer a){
        System.out.println("a = " + a);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            MyConnSingleton of = MyConnSingleton.of();
            Connection conn = of.conn;

        }
//        for (int i = 0; i < 3; i++) {
//            MyConnSingleton.foo1(i);
//        }

    }
}
