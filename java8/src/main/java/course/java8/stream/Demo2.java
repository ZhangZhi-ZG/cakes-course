package course.java8.stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Demo2 {
    //BUG
    public static void main(String[] args) {
        testStream();

        testInnerOperation();
    }

    /**
     * 第二步: 中间操作
     */
    private static void testInnerOperation() {
        List<String> strs = Lists.newArrayList("ab", "xyz", "789", "axy", "azzzzz", "a678", "a1234");
        // 流化
        strs.stream()
                // 过滤
                .filter(str -> str.startsWith("a"))
                // 数据映射，进行数据格式化处理，获取想要的数据
                .map(str -> str.toUpperCase())
                //去重处理
                .distinct()
                //输出每一步中间操作的处理结果，类似于debug功能
                .peek(str-> System.out.println("str = "+str))
                //排序-按照默认的ASCII码进行排序
                .sorted()
                //排序-按照自定义的方式进行排序
                .sorted(Comparator.comparingInt(str->str.length()))
                // 结束操作
                .forEach(str -> System.out.println(str));
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
