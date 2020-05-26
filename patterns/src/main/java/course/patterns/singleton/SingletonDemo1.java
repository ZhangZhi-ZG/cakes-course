package course.patterns.singleton;

/**
 * 饿汉式
 */
public final class SingletonDemo1 {

    public static int abc = 1024;

    private SingletonDemo1() {

    }

    private static final SingletonDemo1 ABC = new SingletonDemo1();

    public static SingletonDemo1 getAbc() {
        return ABC;
    }
}
