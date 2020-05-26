package course.patterns.singleton;

public class ThreadPoolSingletonApp {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ThreadPoolSingleton.of().submit(() -> {
                System.out.println("hello haha 1");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (int i = 0; i < 5; i++) {
            ThreadPoolSingleton.of().submit(() -> {
                System.out.println("hello haha 2");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
