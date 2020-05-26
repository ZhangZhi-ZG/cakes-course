package course.patterns.singleton;

public final class SingletonLiveTemplate {
    private SingletonLiveTemplate() {

    }

    private static class ClassHolder {
        private static final SingletonLiveTemplate INSTANCE = new SingletonLiveTemplate();
    }

    public static SingletonLiveTemplate of() {
        return ClassHolder.INSTANCE;
    }


}
