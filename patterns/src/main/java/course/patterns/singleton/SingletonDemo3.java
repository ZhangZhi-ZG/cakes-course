package course.patterns.singleton;

/**
 * 使用内部类,推荐
 */
public final class SingletonDemo3 {

    private SingletonDemo3() {

    }

    private static class ClassHolder {
        private static final SingletonDemo3 INSTANCE = new SingletonDemo3();
    }

    public static SingletonDemo3 of() {
        return ClassHolder.INSTANCE;
    }
}
