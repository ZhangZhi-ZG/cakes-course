package course.basic.thread;

import java.time.LocalDateTime;

public class Demo6 {
    public static void main(String[] args) throws InterruptedException {
        // Main Thread

        System.out.println("main start:" + LocalDateTime.now());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000 * 10);
                    System.out.println("t1 finished:" + LocalDateTime.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setDaemon(true);
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000 * 20);
                    System.out.println("t2 finished:" + LocalDateTime.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.setDaemon(true);
        t2.start();

        t1.join();
        t2.join();

        System.out.println("main end:" + LocalDateTime.now());
    }
}
