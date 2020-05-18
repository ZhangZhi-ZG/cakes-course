package course.basic.thread;

public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000 * 60 * 3);
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

        // 调了start之后，线程t1 进入就绪状态
        t1.start();

        Thread.sleep(1000);

        System.out.println("before t1.isInterrupted() = " + t1.isInterrupted());

        t1.interrupt();

        System.out.println("after t1.isInterrupted() = " + t1.isInterrupted());

        // 当cpu 切换到此线程时，才会进入到运行状态

        Thread.sleep(1000 * 60 * 5);
    }
}
