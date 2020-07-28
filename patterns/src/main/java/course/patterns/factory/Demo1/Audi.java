package course.patterns.factory.Demo1;

/**
 * @author zzhg
 * @create time 2020-07-28 10:27
 */
public class Audi implements Car {

    @Override
    public void run() {
        System.out.println("Audi.run");
    }

    @Override
    public void band() {
        System.out.println("car band audi");
    }
}
