package course.basic.thread;

public class Demo7 {

    Integer data = 0;

    Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Demo7 demo7 = new Demo7();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    demo7.add();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    demo7.sub();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("demo7.data = " + demo7.data);
    }

    // 此时的锁是 new Demo7(); 这个 对象本身
    // public synchronized void add() {
    //     this.data++;
    //
    //     /**
    //      * 等同于 如下写法
    //      * synchronized (this) {
    //      *    this.data++;
    //      * }
    //      */
    // }
    //
    // public synchronized void sub() {
    //     this.data--;
    // }

    public void add() {
        synchronized (lock) {
            this.data++;
        }
    }

    public void sub() {
        synchronized (lock) {
            this.data--;
        }
    }
}
