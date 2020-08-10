package course.dubbo.springboot.provider.controller;

import course.dubbo.pay.api.model.RetMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PingController.class);

    @RequestMapping("ping")
    public RetMsg ping() {
        LOGGER.info("ping start.");
        return RetMsg.createSuccessMsg();
    }
}
