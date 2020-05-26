package course.java8.lambda;

import java.util.Comparator;
import java.util.function.Function;

/**
 * lambda几种引用
 */
public class Demo5 {
    public static void main(String[] args) {
        foo1();
    }

    private static void foo1() {

        // int compare(T o1, T o2);

        // Integer.compare(o1, o2) 方法实现如下:
        // int compare(int x, int y) {
        //    return (x < y) ? -1 : ((x == y) ? 0 : 1);
        // }
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        int result = comparator.compare(1024, 2048);
        System.out.println("result = " + result);

        // 使用方法引用, 将 (o1, o2) -> Integer.compare(o1, o2) ==》 Integer::compare
        // 静态方法引用
        Comparator<Integer> comparator1 = Integer::compare;
    }

    public static void foo2() {
        // 方法引用， 实例化方法  str -> str.toUpperCase() ==》 String::toUpperCase
        // R apply(T t);
        Function<String, String> func1 = str -> str.toUpperCase();
        Function<String, String> func2 = String::toUpperCase;

        String response = func1.apply("hello world");
    }
}
