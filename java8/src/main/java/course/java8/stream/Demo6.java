package course.java8.stream;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * collect操作
 * 转集合{toList,toSet,toMap}
 * 分组,groupingBy
 * 分区,partitioningBy
 */
public class Demo6 {
    public static void main(String[] args) {
        List<String> strs = Lists.newArrayList("ab", null, "", null, "", "xyz", "789", "abc", "xyz", "dbc", "axyweewwew", "azzzzz", "azzzzz", "azzzzz", "azzzzz", "azzzzz", "a678", "a12345", "a12345", "b1236", "x123", "y123", "z678");

        // testCollectToSet(strs);

        // testCollectToMap(strs);

        // testGroupBy(strs);

        // testPartitioningBy(strs);

        testJoining(strs);

       // testCollectToList(strs);
    }

    private static void testCollectToList(List<String> strs) {
        List<String> stringList = strs.stream()
                .filter(str -> !Strings.isNullOrEmpty(str))
                .map(String::toLowerCase)
                .sorted(Comparator.comparingInt(String::length))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("stringList = " + stringList);
    }

    private static void testJoining(List<String> strs) {
        String data = strs.stream().filter(str -> !Strings.isNullOrEmpty(str))
                .collect(Collectors.joining("+"));

        System.out.println("data = " + data);
    }

    private static void testPartitioningBy(List<String> strs) {
        Map<Boolean, List<String>> data = strs.stream()
                .filter(str -> !Strings.isNullOrEmpty(str))
                .collect(Collectors.partitioningBy(str -> str.length() > 5));

        data.forEach((k, v) -> {
            if (k) {
                System.out.println("分区字符串长度大于5: " + v);
            } else {
                System.out.println("分区字符串小度大于5: " + v);
            }
        });
    }

    private static void testGroupBy(List<String> strs) {
        Map<Integer, List<String>> data = strs.stream()
                .filter(str -> !Strings.isNullOrEmpty(str))
                .collect(Collectors.groupingBy(String::length));

        data.forEach((k, v) -> {
            System.out.println("所属分组为长度=" + k);
            System.out.println("       数据内容==" + v);
            System.out.println("\n");
        });
    }

    private static void testCollectToMap(List<String> strs) {
        Map<String, Integer> data = strs.stream()
                .filter(str -> str.length() > 3)
                .map(str -> str + "*")
                .distinct()
                .collect(Collectors.toMap(str -> str, String::length));

        data.forEach((k, v) -> {
            System.out.println("data map: k=" + k + ", v=" + v);
        });
    }

    private static void testCollectToSet(List<String> strs) {
        Set<String> data = strs.stream()
                .filter(str -> str.length() > 3)
                .map(str -> str + "*")
                .collect(Collectors.toSet());
        System.out.println("data = " + data);
    }


}
