package course.spring.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) throws ClassNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("demo2/beans.xml");

        //class类型
        HeheService service = context.getBean(HeheService.class);
        //bean的ID
        // HeheService service = (HeheService) context.getBean("heheService");
        String msg = service.sayHehe("hehe 呵呵呵呵呵");

        System.out.println(msg);
    }
}
