package course.spring.demo6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        //加载声明的配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(Demo6Configuration.class);
        //根据方法类型获取bean
        HelloService helloService = context.getBean(HelloService.class);

        String res = helloService.sayHello("java");

        System.out.println("res = " + res);
    }
}
