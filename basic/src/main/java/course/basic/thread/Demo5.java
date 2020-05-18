package course.basic.thread;

/**
 * 线程和任务 分离
 */
public class Demo5 {

    public static void main(String[] args) {

        startThread(new ReadFileTask());
        startThread(new ReadMySQLTask());
        startThread(new HttpRequestTask());
    }

    public static void startThread(Runnable runnable) {
        // 池化
        Thread thread = new Thread(runnable);

        thread.start();
    }

    static class ReadFileTask implements Runnable {

        @Override
        public void run() {
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
