package course.basic.collection;

import java.util.*;

/**
 * @author haoc
 */
public class ListDemo1 {


    public static void main(String[] args) {
//    test1();

//    test2();

//    test3();

//    test4();

        test5();
    }

    public static void foo() {


    }


    public static void test5() {
        LinkedList<String> alist = new LinkedList<>();
        alist.add("zhang san");
        // alist.

        List<String> list = new ArrayList<>();
        //添加元素
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("list = " + list);
        //根据索引获取子列表
        List<String> newList = list.subList(0, 2);

        System.out.println("newList = " + newList);
        list.subList(0, 1);
        String[] strArr = list.toArray(new String[]{"0"});
        Arrays.stream(strArr).forEach(str -> System.out.println("str = " + str));
        // for (String s : strArr) {
        //     System.out.println("s = " + s);
        // }
    }


    public static void test4() {
        List<String> list1 = new ArrayList<>();
        //判断列表是否为空
        boolean isEmp1 = list1.isEmpty();
        System.out.println("isEmp1 = " + isEmp1);

        list1.add("a");
        list1.add("b");
        list1.add("c");
        //根据索引获取元素
        String s = list1.get(1);

        System.out.println(s);

        boolean isEmp2 = list1.isEmpty();
        System.out.println("isEmp2 = " + isEmp2);

        //根据索引修改元素值

        list1.set(1, "hello");
        for (String ss : list1) {
            System.out.println(ss);
        }
    }

    public static void test3() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");

        //判断列表是否包含某元素,返回值类型为boolean
        boolean isEq1 = list1.contains("d");
        boolean isEq2 = list1.contains("a");

        System.out.println("isEq1 = " + isEq1);
        System.out.println("isEq2 = " + isEq2);
    }

    public static void test2() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");

        List<String> list2 = new ArrayList<>();
        list2.add("h");
        list2.add("l");
        list2.add("k");

        //列表添加其它列表
        list1.addAll(list2);

        for (String s : list1) {
            System.out.println(s);
        }
    }


    public static void test1() {
        List<String> list1 = new ArrayList<>();

        list1.add("a");
        list1.add("b");
        list1.add("c");
        //循环获取列表中的元素
        for (String val : list1) {
            System.out.println("val = " + val);
        }
    }

}
