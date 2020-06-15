package course.spring.demo7.controller;

import course.spring.demo7.service.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PingController {

    @Autowired
    private PingService service;

    public void ping(String msg) {
        service.ping(msg);
    }
}
