package course.dubbo.pay.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 未发起真实的业务调用,只为做 check=false的演示
 */
public class App2 {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");

        applicationContext.getBean("payService");

        System.in.read();
    }
}
