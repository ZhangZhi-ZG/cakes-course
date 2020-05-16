package course.basic.assignment;



import course.basic.oop.MaoPao;

import java.util.*;

/**
 * @author zzhg
 * @date 2020-05-12
 *
 * 给定一个HashSet，排序其中元素，输出
 */
public class Order {
    public Integer[] orderDemo(Set<Integer> set){
        //定义一个ArrayList，用来存放HashSet中的值
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : set) {
            //list添加值
            list.add(i);
        }
        //定义一个指定大小的Integer数组
        Integer[] i = new Integer[list.size()];
        //将list转换为Integer数组
        Integer[] IntArray = list.toArray(i);
        //调用自己写的冒泡排序方法
        MaoPao m = new MaoPao();
        Integer[] nums = m.nums(IntArray);
        //HashSet是无序的，添加数据与取出数据时，顺序不一样
//        HashSet<Integer> new_set = new HashSet<>();
//        for (Integer num : nums) {
//            System.out.println("num = " + num);
//            new_set.add(num);
//        }
        return nums;
//        System.out.println("list = " + IntArray);
    }
}
