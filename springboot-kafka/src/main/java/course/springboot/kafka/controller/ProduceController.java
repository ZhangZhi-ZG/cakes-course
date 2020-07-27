package course.springboot.kafka.controller;

import course.springboot.kafka.component.CommonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceController {

    @Autowired
    private CommonProducer producer;

    @RequestMapping("/send")
    public String sendMsg(@RequestParam("msg") String msg) {
        producer.sendMsg(msg);
        return "success";
    }
}
