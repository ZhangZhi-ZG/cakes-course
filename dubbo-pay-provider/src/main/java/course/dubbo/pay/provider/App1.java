package course.dubbo.pay.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App1 {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("provider1.xml");
        applicationContext.start();
        System.in.read();
    }
}
