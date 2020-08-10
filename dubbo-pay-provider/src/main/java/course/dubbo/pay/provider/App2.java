package course.dubbo.pay.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App2 {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("provider2.xml");
        applicationContext.start();
        System.in.read();
    }
}
