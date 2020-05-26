package course.patterns.singleton;

/**
 * 懒汉式
 */
public final class SingletonDemo2 {

    private static volatile SingletonDemo2 INSTANCE;

    private SingletonDemo2() {

    }

    public static SingletonDemo2 getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonDemo2.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDemo2();
                }
            }
        }

        return INSTANCE;
    }
}
