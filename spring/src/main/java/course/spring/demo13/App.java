package course.spring.demo13;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.ArrayList;

/**
 * @author zzhg
 * @date 2020-06-09
 */
public class App {



    public static void main(String[] args) {
        // foo1();
        foo2();
    }

    private static void foo2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo13/beans.xml");
        Foo foo = context.getBean(Foo.class);
        System.out.println("foo.toString() = " + foo.toString());
    }

    public static void foo1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Demo13Conf.class);
        Car bwm = context.getBean(Car.class);
        bwm.band("bwm");
        bwm.mile(1000);
        bwm.run("加速跑起来");
    }


}
