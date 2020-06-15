package course.patterns.singleton;

/**
 * 使用内部类,推荐
 */
public enum SingletonDemo4 {
    //对象实例化
    INSTANCE;

    public void test() {

    }

    public static void main(String[] args) {
        SingletonDemo4 instance = SingletonDemo4.INSTANCE;
    }
}
