package course.spring.demo4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Demo4Configuration.class);

        Demo4Foo demo4Foo = context.getBean(Demo4Foo.class);

        String msg = demo4Foo.foo("hehe");

        System.out.println(msg);
    }
}
