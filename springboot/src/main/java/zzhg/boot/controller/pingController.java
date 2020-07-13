package zzhg.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author zzhg
 * @date 2020-06-24
 */
@RestController
@RequestMapping("/example")
public class pingController {
    private static final Logger LOGGER =  LoggerFactory.getLogger(pingController.class);


    @RequestMapping("/ping")
    public String ping(){
        LOGGER.info("start ping service..");
        return "pong--当前系统时间: "+ LocalDateTime.now();
    }
}
