package course.java8;

/**
 * @author zzhg
 * @date 2020-05-24
 */
public class testLambda {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("i = " + i);
            }
        });
        thread.start();

        //匿名内部类
        Runnable run = new Runnable() {
            @Override
            public void run() {

            }
        };
        Runnable run1 = () -> System.out.println("lambda");
    }
}
