package course.java8.lambda;

import java.time.LocalDateTime;
import java.util.function.*;

/**
 * 函数式接口类型:
 * - java.util.function.Function<T, R>   : 转化型
 * - java.util.function.Consumer<T>      : 消费型
 * - java.util.function.Supplier<T>      : 供给型
 * - java.util.function.Predicate<T>     : 断言型
 * <p>
 * 备注: java.util.function此包下都是java8帮我们定义好的一些函数式接口，可以直接使用，不用自己在去定义了
 */
public class Demo4 {

    public static void main(String[] args) {
        // testFunction();

        // testConsumer();

        // testSupplier();

        testPredicate();
    }

    private static void testPredicate() {
        Predicate<Integer> predicate = num -> num > 1024;
        predicate.test(2048);
        predicate.test(1000);

        LongPredicate longPredicate = l -> l > 2048;
        longPredicate.test(1024);
    }

    private static void testSupplier() {
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();

        LocalDateTime dateTime = supplier.get();

        System.out.println("dateTime = " + dateTime);
    }

    private static void testConsumer() {
        Consumer<String> consumer = str -> {
            int length = str.length();
            System.out.println("length = " + length);
        };

        consumer.accept("hello java8 lambda");
    }

    public static void testFunction() {
        // R apply(T t);
        Function<String, String> func = str -> str.toUpperCase();
        String funcResp = func.apply("hello world");
        System.out.println("funcResp = " + funcResp);


        Function<String, Integer> func1 = str -> str.length();
        Integer strLen = func1.apply("hello world");
        System.out.println("strLen = " + strLen);
    }
}
