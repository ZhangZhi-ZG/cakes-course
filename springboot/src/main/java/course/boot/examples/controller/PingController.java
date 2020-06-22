package course.boot.examples.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
@RestController
public class PingController {

    @RequestMapping("/ping")
    public String ping() {
        return "pong:" + LocalDateTime.now();
    }
}
