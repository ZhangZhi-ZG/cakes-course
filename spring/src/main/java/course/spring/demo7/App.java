package course.spring.demo7;

import course.spring.demo7.controller.PingController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Demo7Conf.class);

        PingController controller = context.getBean(PingController.class);

        controller.ping("hello");
    }
}
