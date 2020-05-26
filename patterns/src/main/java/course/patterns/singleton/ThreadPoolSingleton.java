package course.patterns.singleton;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ThreadPoolSingleton {

    private ExecutorService executorService;

    private ThreadPoolSingleton() {
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 5);
        System.out.println("executorService = " + executorService);
    }

    private static class ClassHolder {
        private static final ThreadPoolSingleton INSTANCE = new ThreadPoolSingleton();
    }

    public static ThreadPoolSingleton of() {
        return ClassHolder.INSTANCE;
    }

    public void submit(Runnable runnable) {
        this.executorService.submit(runnable);
    }

    public void submit(List<Runnable> runnables) {
        for (Runnable runnable : runnables) {
            this.executorService.submit(runnable);
        }
    }

    /**
     * 不规范写法
     */
    // public void foo() {
    //     ExecutorService executorService = Executors.newFixedThreadPool(32);
    //     for (int i = 0; i < 1000; i++) {
    //         executorService.submit(() -> {
    //             System.out.println("ThreadPoolSingleton.foo");
    //         });
    //     }
    //
    //     // do  sth....
    // }

}
