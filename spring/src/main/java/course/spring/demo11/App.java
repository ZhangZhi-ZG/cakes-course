package course.spring.demo11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Demo11Configuration.class);

        Demo11FooService fooService = context.getBean(Demo11FooService.class);

        fooService.foo1();
    }
}
