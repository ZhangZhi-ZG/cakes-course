package course.java8.stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Demo2 {

    public static void main(String[] args) {
        testStream();

        testInnerOperation();
    }

    /**
     * 第二步: 中间操作
     */
    private static void testInnerOperation() {
        List<String> strs = Lists.newArrayList("ab", "xyz", "789", "axy", "azzzzz", "a678", "a1234");

        strs.stream() // 流化
                .filter(str -> str.startsWith("a")) // 中间操作
                .filter(str -> str.startsWith("a")) // 中间操作
                .filter(str -> str.startsWith("a")) // 中间操作
                .filter(str -> str.startsWith("a")) // 中间操作
                .filter(str -> str.startsWith("a")) // 中间操作
                .filter(str -> str.startsWith("a")) // 中间操作
                .filter(str -> str.startsWith("a")) // 中间操作
                .filter(str -> str.startsWith("a")) // 中间操作
                .filter(str -> str.startsWith("a")) // 中间操作
                .filter(str -> str.startsWith("a")) // 中间操作
                .filter(str -> str.startsWith("a")) // 中间操作
                .map(str -> str.toUpperCase())      // 中间操作
                .map(str -> str.toUpperCase())      // 中间操作
                .map(str -> str.toUpperCase())      // 中间操作
                .map(str -> str.toUpperCase())      // 中间操作
                .map(str -> str.toUpperCase())      // 中间操作
                .map(str -> str.toUpperCase())      // 中间操作
                .map(str -> str.toUpperCase())      // 中间操作
                .map(str -> str.toUpperCase())      // 中间操作
                .map(str -> str.toUpperCase())      // 中间操作
                .map(str -> str.toUpperCase())      // 中间操作
                .forEach(str -> System.out.println(str));  // 结束操作
    }

    /**
     * 第一步: 流化操作
     */
    private static void testStream() {
        List<String> strs = Lists.newArrayList("ab", "xyz", "789", "axy", "azzzzz", "a678", "a1234");
        Set<String> sets = Sets.newHashSet();

        int[] arr = new int[10];

        // 1.流化操作, 普通流
        strs.stream();
        sets.stream();
        Arrays.stream(arr);

        // 2.并行流
        strs.parallelStream();
        sets.parallelStream();
    }

}
