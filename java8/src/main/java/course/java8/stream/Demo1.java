package course.java8.stream;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * jdk1.8之前写法与jdk1.8现在写法 对比
 */
public class Demo1 {

    private static final List<String> STR_LIST = Lists.newArrayList("ab", "xyz", "789", "axy", "azzzzz", "a678", "a1234");

    public static void main(String[] args) {
        // 过滤字符串，找到以a开头的，排序，后生成一个字符串，并用，进行分割
        // abc,axy,azz -> "abc,axy,azz"

        foo1();

        foo2();
    }

    /**
     * 使用jdk1.8之前的原生写法
     */
    public static void foo1() {
        List<String> bufList = Lists.newArrayList();
        for (String s : STR_LIST) {
            if (!s.startsWith("a")) {
                continue;
            }

            bufList.add(s);
        }

        bufList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bufList.size(); i++) {
            if (i == bufList.size() - 1) {
                builder.append(bufList.get(i));
                continue;
            }

            builder.append(bufList.get(i)).append(",");
        }

        String result = builder.toString();

        System.out.println("foo1 result = " + result);
    }

    /**
     * 使用jdk1.8 lambda+stream来处理
     */
    public static void foo2() {
        String result = STR_LIST.stream()
                .filter(str -> str.startsWith("a"))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.joining(","));

        System.out.println("foo2 result = " + result);
    }
}
