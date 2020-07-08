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

//        Predicate<Integer> predicate = num -> num > 1024;
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 1024;
            }
        };
        predicate.test(2048);
        predicate.test(1000);

        LongPredicate longPredicate = l -> l > 2048;
        boolean test = longPredicate.test(1024);
        System.out.println("test = " + test);

    }

    private static void testSupplier() {

        Supplier<LocalDateTime> supplier1 = new Supplier<LocalDateTime>() {
            @Override
            public LocalDateTime get() {
                return LocalDateTime.now();
            }
        };
        Supplier<LocalDateTime> supplier = LocalDateTime::now;

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
        //匿名函数实现
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        Function<String, String> func = String::toUpperCase;
        String funcResp = func.apply("hello world");
        System.out.println("funcResp = " + funcResp);


        Function<String, Integer> func1 = str -> str.length();
        Integer strLen = func1.apply("hello world");
        System.out.println("strLen = " + strLen);
    }
}
