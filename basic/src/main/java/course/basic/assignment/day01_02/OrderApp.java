package course.basic.assignment.day01_02;

import course.basic.assignment.day01_02.Order;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zzhg
 * @date 2020-05-14
 */
public class OrderApp {
    public static void main(String[] args) {
        Order order = new Order();
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(2);
        set.add(123);
        set.add(33123);
        set.add(1234);
        set.add(5678);
//        Set set1 = order.orderDemo(set);
//        System.out.println("set1 = " + set1);
        Integer[] demo = order.orderDemo(set);
        //将Integer数组转换为String类型
        System.out.println(Arrays.toString(demo));
    }
}
