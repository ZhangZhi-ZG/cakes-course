package course.java8.lambda;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 请客观，用眼睛看，哪种写法 让人会产生"高潮"
 */
public class Demo6 {

    public static void main(String[] args) {
        foo1();
//        foo2();
    }

    private static void foo1() {
        List<String> strings = Lists.newArrayList("a1", "a2", "a3", "b1", "b2");
        String result = strings.stream()
                .filter(s -> s.startsWith("a"))
                .map(String::toUpperCase)
                .collect(Collectors.joining("+"));
//        Stream<String> stream = strings.stream();
//        stream.forEach(str-> System.out.println("str ="+str));
        System.out.println("result = " + result);
    }

    private static void foo2() {
        List<String> strings = Lists.newArrayList("a1", "a2", "a3", "b1", "b2");
        String result = strings.stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return s.startsWith("a");
                    }
                })
                .map(new Function<String, String>() {

                    @Override
                    public String apply(String s) {
                        return s.toUpperCase();
                    }
                })
                .collect(Collectors.joining("+"));
        System.out.println("result = " + result);
    }
}
