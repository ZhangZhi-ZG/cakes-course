package course.spring.demo5;

import course.spring.demo5.conf.Demo5Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Demo5Configuration.class);

        Demo5Foo1 demo5Foo = context.getBean(Demo5Foo1.class);

        String msg = demo5Foo.foo("hello");

        System.out.println(msg);
    }
}
