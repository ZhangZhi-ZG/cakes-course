package course.java8.stream;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

public class Demo3 {

    public static void main(String[] args) {
        List<String> strs = Lists.newArrayList("ab", "xyz", "789", "axy", "azzzzz", "a678", "a1234", "b1236", "x123", "y123", "z678");

        // testFilter(strs);

        // testMap(strs);

        // testSort(strs);

        // testLimitAndSkip(strs);

        testFlatMap();
    }

    private static void testFlatMap() {
        List<List<String>> strsList = Lists.newArrayList();

        List<String> strs1 = Lists.newArrayList("ab", "xyz", "789");
        List<String> strs2 = Lists.newArrayList("xy", "ww", "8990");
        List<String> strs3 = Lists.newArrayList("cd", "sss", "13311");
        List<String> strs4 = Lists.newArrayList("uii", "sdfdsfdf", "678");

        strsList.add(strs1);
        strsList.add(strs2);
        strsList.add(strs3);
        strsList.add(strs4);

        // -------
        // 需求: 将大集合中的所有字符串 全部转成大写
        // 用之前所学的转化操作，就这样搞，但是比较恶心.
        // Stream<List<String>> stream = strsList.stream();
        // stream.forEach(strList -> {
        //     strList.stream().map(String::toUpperCase).forEach(str -> {
        //         System.out.println("str = " + str);
        //     });
        // });

        strsList.stream()
                // flatMap 做了啥
                .flatMap(strList -> strList.stream())
                .map(str->str.toUpperCase())
                .forEach(str -> System.out.println("str=" + str));
    }

    /**
     * 中间操作: skip + limit
     *
     * @param strs
     */
    private static void testLimitAndSkip(List<String> strs) {
        strs.stream()
                .peek(str -> System.out.println("strs === " + str))
                .skip(2)
                .limit(3)
                .forEach(str -> System.out.println("str=" + str));

        System.out.println("----------------");

        strs.stream()
                .skip(3)
                .limit(5)
                .forEach(str -> System.out.println("str=" + str));
    }

    /**
     * 中间操作 排序
     *
     * @param strs
     */
    private static void testSort(List<String> strs) {
        // 默认的排序方式
        strs.stream().sorted().forEach(str -> System.out.println("str=" + str));
        System.out.println("-----------");
        strs.stream().sorted(Comparator.comparingInt(String::length)).forEach(str -> System.out.println("str=" + str));
    }

    /**
     * 中间操作 映射操作
     *
     * @param strs
     */
    private static void testMap(List<String> strs) {
        strs.stream()
                .map(String::toUpperCase)
                .map(str -> str + ";")
                .map(str -> str + "+")
                .forEach(str -> System.out.println("str=" + str));
    }

    /**
     * 中间操作 过滤器 filter演示
     *
     * @param strs
     */
    private static void testFilter(List<String> strs) {
        strs.stream()
                .filter(str -> str.length() >= 5)  // 第一个过滤器: 字符串长度大于等于5
                .filter(str -> str.startsWith("b")) // 第二个过滤器: 以字符b开头的
                .forEach(str -> System.out.println("str=" + str));
    }
}
