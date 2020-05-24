package course.basic.jdbc;

import com.google.common.collect.Lists;

import java.util.List;

public class DemoForWriteApp {

    public static void main(String[] args) {
        // testInsert();
        // testUpdate();
        testDelete();
    }

    private static void testDelete() {
        String sql = "delete from tb_user where id=?";
        List<Object> params = Lists.newArrayList();
        params.add(7);


        int rows = DemoForWrite.modify(sql, params);
        System.out.println("rows = " + rows);
    }

    private static void testUpdate() {
        String sql = "update tb_user set name=?,age=? where id=?";
        List<Object> params = Lists.newArrayList();
        params.add("hehehehe");
        params.add(67);
        params.add(5);


        int rows = DemoForWrite.modify(sql, params);
        System.out.println("rows = " + rows);
    }

    private static void testInsert() {
        String sql = "insert into tb_user(name,age) values(?,?)";
        List<Object> params = Lists.newArrayList();
        params.add("xixihaha");
        params.add(34);


        int rows = DemoForWrite.modify(sql, params);
        System.out.println("rows = " + rows);
    }
}
