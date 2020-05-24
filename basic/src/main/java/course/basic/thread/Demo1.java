package course.basic.thread;

public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("当前线程是 = " + Thread.currentThread().getName());
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                System.out.println("大爷啊， 有人打断我睡觉");
                // 文件的各种 记录，保存，提交啊，，，，，
            }

            /**

             if xxxx 逻辑
                throw XxxxException

             */
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("当前线程是 = " + Thread.currentThread().getName());
                System.out.println("切换到线程2。。。");
                Thread.sleep(1000 * 30);
            } catch (InterruptedException e) {
                System.out.println("大爷啊， 有人打断我睡觉");
                // 文件的各种 记录，保存，提交啊，，，，，
            }

            /**

             if xxxx 逻辑
             throw XxxxException

             */
        });
        t1.setName("hahahahahahaahh");
        t2.setName("hehehehehehehe");
        // 调了start之后，线程t1 进入就绪状态
        t1.start();
        t2.start();
        System.out.println("t1.getState() = " + t1.getState());
        System.out.println("主线程。。。");
//        Thread.sleep(1000);
//
        System.out.println("before t1.isInterrupted() = " + t1.isInterrupted());
        //调用interrupt后，会中断当前线程，此时cpu会切换到其它线程
        t1.interrupt();
        System.out.println("t1.getState() = " + t1.getState());
        //等待线程销毁，继续往下执行
        t1.join();
        System.out.println("after t1.isInterrupted() = " + t1.isInterrupted());
//
//        // 当cpu 切换到此线程时，才会进入到运行状态
//
//        Thread.sleep(1000 * 60 * 5);
    }
}
