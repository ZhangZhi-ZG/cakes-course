package course.java8.stream;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 结束操作
 * - 直接拿到结果
 * + count
 * + findFist
 * + findAny
 * + forEach
 * - 做统计, collect*
 */
public class Demo4 {
    public static void main(String[] args) {
        List<String> strs = Lists.newArrayList("ab", "xyz", "789", "axyweewwew", "azzzzz", "azzzzz", "azzzzz", "azzzzz", "azzzzz", "a678", "a12345", "a12345", "b1236", "x123", "y123", "z678");

        // testCount(strs);

        // testFindFirst(strs);

        testCollect1(strs);
    }

    private static void testCollect1(List<String> strs) {
        List<String> result = strs.stream()
                .filter(str -> str.length() > 5)
                .map(String::toUpperCase)
                .sorted()
                .distinct() // 去重
                .collect(Collectors.toList());

        System.out.println("result = " + result);
    }

    private static void testFindFirst(List<String> strs) {
        Optional<String> optional = strs.stream().filter(str -> str.startsWith("99999")).findFirst();
        if (optional.isPresent()) {
            String val = optional.get();
            System.out.println("val = " + val);
        }
    }

    private static void testCount(List<String> strs) {
        long count = strs.stream().filter(str -> str.length() > 3)
                .peek(str -> System.out.println("str = " + str))
                .count();
        System.out.println("count = " + count);
        // .forEach(str -> System.out.println("str=" + str));
    }
}
