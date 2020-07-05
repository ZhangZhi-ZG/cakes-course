package course.schema.sync.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
@RestController
public class PingController {

    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }
}
