package course.basic.thread;

/**
 * 线程和任务 整一起了
 */
public class Demo4 {

    public static void main(String[] args) {
        ReadFileTaskThread readFileTaskThread = new ReadFileTaskThread();
        readFileTaskThread.start();

        ReadMySQLTaskThread readMySQLTaskThread = new ReadMySQLTaskThread();
        readMySQLTaskThread.start();

        HttpRequestTaskThread httpRequestTaskThread = new HttpRequestTaskThread();
        httpRequestTaskThread.start();
    }

    static class ReadFileTaskThread extends Thread {

        @Override
        public void run() {
            System.out.println("读文件");
        }
    }

    static class ReadMySQLTaskThread extends Thread {

        @Override
        public void run() {
            System.out.println("读MySQL");
        }
    }

    static class HttpRequestTaskThread extends Thread {

        @Override
        public void run() {
            System.out.println("http 请求");
        }
    }



}
