package course.patterns.decorator;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class App2 {

    public static void main(String[] args) {
        String str = "name=haha-randomStr(12), age=23+randomStr(2), info=xyz-randomId(3):-randomStr(5)";

        String resp = DecoratorManager.of().doDecorate(str);

        System.out.println("resp = " + resp);
    }
}
