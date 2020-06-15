package course.spring.demo3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("demo3/beans.xml");

        XixiService service = context.getBean(XixiService.class);

        String msg = service.sayXixi("spring");

        System.out.println(msg);

        Demo3Foo1 foo1 = context.getBean(Demo3Foo1.class);
        Demo3Foo2 foo2 = context.getBean(Demo3Foo2.class);
        Demo3Foo3 foo3 = context.getBean(Demo3Foo3.class);

        foo1.foo("spring");
        foo2.foo("netty");
        foo3.foo("java");
    }
}
