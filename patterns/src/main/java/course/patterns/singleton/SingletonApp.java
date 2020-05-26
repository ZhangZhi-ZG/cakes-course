package course.patterns.singleton;

public class SingletonApp {

    public static void main(String[] args) {
        testSingleton1();
    }

    private static void testSingleton1() {
        SingletonDemo1 instance1 = SingletonDemo1.getAbc();
        SingletonDemo1 instance2 = SingletonDemo1.getAbc();
        SingletonDemo1 instance3 = SingletonDemo1.getAbc();
        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);
        System.out.println("instance3 = " + instance3);

        SingletonDemo4.INSTANCE.test();
    }
}
