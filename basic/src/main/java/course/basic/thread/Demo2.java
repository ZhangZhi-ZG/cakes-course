package course.basic.thread;

public class Demo2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("hello java thread.");
            }
        });

        t1.start();

        // 1
        new Thread();

        // 2
        // Runnable runnable = new Runnable();
    }
}
