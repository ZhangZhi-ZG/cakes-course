package course.dubbo.pay.consumer;

import course.dubbo.pay.api.model.PayInfo;
import course.dubbo.pay.api.model.RetMsg;
import course.dubbo.pay.api.service.PayService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");

        applicationContext.start();

        PayService payService = (PayService) applicationContext.getBean("payService");

        RetMsg retMsg = payService.pay(new PayInfo());

        System.out.println("retMsg = " + retMsg);

        System.in.read();
    }
}
