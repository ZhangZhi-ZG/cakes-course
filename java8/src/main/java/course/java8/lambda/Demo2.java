package course.java8.lambda;

import java.util.Comparator;
import java.util.function.Function;

public class Demo2 {
    public static void main(String[] args) {
        foo1();
    }

    public static void foo1() {
        /**
         * lambda语法结构:以->作为分隔，分成左右两部分。
         * 左边: 是我们的参数列表
         *      - 参数可以有多个,多个时是一定需要加 () 的，
         *      - 即使没有参数也要写一个 空的括号
         *      - 当只有一个参数时，可以省略括号
         * 右边: 是方法体
         *      - 多行代码时方法体需要用{}包裹。
         *      - 当只有一行代码时，可以省略{},且即使有返回值，也可以省略掉return
         */

        // demo1.
        // Runnable r = new Runnable() {
        //     @Override
        //     public void run() {
        //          System.out.println("Demo1.run2")
        //     }
        // };
        Runnable r = () -> System.out.println("Demo1.run2");
        Thread thread = new Thread(r);
        thread.start();

        // demo2.
        // Comparator<Integer> comparator = new Comparator<Integer>() {
        //
        //     @Override
        //     public int compare(Integer o1, Integer o2) {
        //         return 0;
        //     }
        // };
        // 可以基于类型推断<Integer>  推断出 参数都是Integer，因此就可以不需要再写了。省略即可，但是你非要加 也不报错
        // Comparator<Integer> comparator = (Integer i1, Integer i2) -> Integer.compare(i1, i2);
        Comparator<Integer> comparator = (i1, i2) -> Integer.compare(i1, i2);

        // demo3.
        // Function func = new Function<String, String>() {
        //
        //     @Override
        //     public String apply(String s) {
        //         return s.toUpperCase();
        //     }
        // };
        // 第一版.
        Function<String, String> func1 = str -> {
            return str.toUpperCase();
        };
        // 第二版.
        Function<String, String> func2 = str -> str.toUpperCase();
        // 第三版
        Function<String, String> func3 = String::toUpperCase;
        String resp = func2.apply("hello");
        System.out.println("func apply resp = " + resp);

        // demo4
        Runnable rr = () -> {
            System.out.println("Demo1.run2");
            System.out.println("Demo1.run2");
            System.out.println("Demo1.run2");
            System.out.println("Demo1.run2");
            System.out.println("Demo1.run2");
        };

        // demo5
        Function<String, String> func4 = str -> {
            System.out.println("Demo2.str = " + str);
            return str.toUpperCase();
        };

        // demo6
        FuncFoo ff = new FuncFoo();
        String ffResp = ff.apply("hello");
        System.out.println("ffResp = " + ffResp);
    }

    static class FuncFoo implements Function<String, String> {

        @Override
        public String apply(String s) {
            return s.toUpperCase();
        }
    }

    public static void foo2() {
        // 1.自己先实现接口，新建一个类 RunTest,然后创建对象。再然后调用方法完成具体事宜
        RunTest runTest1 = new RunTest();
        runTest1.run();

        // 2.不用自己新建一个类，使用匿名内部类来玩
        Runnable runTest2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("RunTest.run2");
            }
        };
        runTest2.run();

        // 3.使用lambda,
        // () -> System.out.println("RunTest.run2"); ==》 相当于是描述了接口的具体任务方法并最终 新建了一个对象出来给到runTest3
        Runnable runTest3 = () -> System.out.println("RunTest.run2");
        runTest3.run();
    }

    static class RunTest implements Runnable {

        @Override
        public void run() {
            System.out.println("RunTest.run1");
        }
    }


    /**
     * 证明是否所有接口都可以用匿名内部类? 答曰: 是的
     */
    public static void foo3() {
        Foo3 foo3 = new Foo3() {
            @Override
            public void foo1() {

            }

            @Override
            public void foo2() {

            }

            @Override
            public String foo3() {
                return null;
            }
        };
    }

    interface Foo3 {
        void foo1();

        void foo2();

        String foo3();
    }

    public static void foo4() {
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };

        Comparator<Integer> comparator2 = (Integer o1, Integer o2) -> {
            return 0;
        };

        Comparator<Integer> comparator3 = (o1, o2) -> {
            return 0;
        };

        Comparator<Integer> comparator4 = (o1, o2) -> 0;
    }

    public static void foo5() {
        // 1.
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };

        // 2.
        Comparator<Integer> comparator1 = new ComparatorFoo();
    }

    static class ComparatorFoo implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    }
}
