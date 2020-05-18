package course.basic.thread;

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
