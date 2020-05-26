package course.basic.thread;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Demo3 {

    public static void main(String[] args) {
        runTask(new ReadFileTask());
        runTask(new ReadMySQLTask());
        runTask(new HttpRequestTask());
    }

    // 新建了线程,给我个任务，我去执行
    static void runTask(Runnable runnable) {
        Thread thread = new Thread(runnable);

        thread.start();
        thread.setName("test"+  LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
        thread.interrupt();

    }

    static class ReadFileTask implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            System.out.println("读文件");
        }
    }

    static class ReadMySQLTask implements Runnable {

        @Override
        public void run() {
            System.out.println("读MySQL");
        }
    }

    static class HttpRequestTask implements Runnable {

        @Override
        public void run() {
            System.out.println("http 请求");
        }
    }

}
