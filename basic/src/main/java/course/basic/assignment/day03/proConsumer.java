package course.basic.assignment.day03;

/**
 * @author zzhg
 * @date 2020-05-23
 */
public class proConsumer {

    private Integer count = 0;

    Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        proConsumer pc = new proConsumer();
        Thread t1 = new Thread(pc.new producer());
        Thread t2 = new Thread(pc.new consumer());
        Thread t3 = new Thread(pc.new producer());
        Thread t4 = new Thread(pc.new consumer());
        Thread t5 = new Thread(pc.new consumer());
        Thread t6 = new Thread(pc.new consumer());
        t1.start();
        System.out.println("t1.getState() = " + t1.getState());


        t4.start();
        System.out.println("t4.getState() = " + t4.getState());
        //hread.sleep(1000);

        t3.start();
        System.out.println("t3.getState() = " + t3.getState());
        Thread.sleep(1000);
        t2.start();
        System.out.println("t2.getState() = " + t2.getState());
//        t5.start();
//        t6.start();



    }

    private class producer implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + "生产者 " + count);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (count==10){
                        try {
                            System.out.println("producer");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count ++;

                    lock.notifyAll();
                }
            }
        }
    }

    private class consumer implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 11; i++) {
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + "消费者"+i + "数量"+count);
                    while (count==0){
                        try {
                            System.out.println("test"+i);
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count --;

                    lock.notifyAll();
                }
            }
        }
    }

}
