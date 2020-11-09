package course.java8.lambda;

public class Demo1 {

    public void foo1() {
        // 1.匿名函数
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("Demo1.run");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        // 2.
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Demo1.run");
            }
        });
        thread1.start();
    }

    public void foo2() {

        // lambda 表达式做的简化写法处理
        Runnable runnable1 = () -> System.out.println("Demo1.run1");
        Runnable runnable2 = () -> System.out.println("Demo1.run2");

        Thread thread = new Thread(runnable2);
        thread.start();

        // 2.
        Thread thread2 = new Thread(() -> System.out.println("Demo1.run"));
        thread2.start();
    }
}
