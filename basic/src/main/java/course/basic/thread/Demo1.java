package course.basic.thread;

public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {

                System.out.println("当前线程是 = " + Thread.currentThread().getName());
                System.out.println("t1线程当前状态 = " + Thread.currentThread().getState());
                System.out.println("t1线程等待中。。");
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                System.out.println("大爷啊， 有人打断我睡觉");
                System.out.println("t1线程被打断，当前线程为 = " + Thread.currentThread().getName()+"线程状态是"+Thread.currentThread().getState());
                // 文件的各种 记录，保存，提交啊，，，，，
            }

            /**

             if xxxx 逻辑
             throw XxxxException

             */
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("切换到线程t2。。。"+Thread.currentThread().getName());
                System.out.println("t2线程当前状态 = " + Thread.currentThread().getState());

                System.out.println("t2线程等待中。。");
                Thread.sleep(1000 * 6);
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
        // 调了start之后，线程t1 、t2进入就绪状态,等待CPU的调用
        t1.start();

        t2.start();
        System.out.println("主线程。。。");
//        System.out.println("before t1.isInterrupted() = " + t1.isInterrupted());
        //调用interrupt后，会中断当前线程任务
        t1.interrupt();


        //等待线程销毁后，继续往下执行
        t1.join();
        System.out.println("t1.getState() = " + t1.getState());

        t2.join();
        System.out.println("t2.getState() = " + t2.getState());
    }
}
