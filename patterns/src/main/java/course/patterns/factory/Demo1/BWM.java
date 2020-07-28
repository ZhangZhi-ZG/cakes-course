package course.patterns.factory.Demo1;

/**
 * @author zzhg
 * @create time 2020-07-28 10:26
 */
public class BWM implements Car {
    @Override
    public void run() {
        System.out.println("BWM.run");
    }

    @Override
    public void band() {
        System.out.println("car band BWM");
    }
}
