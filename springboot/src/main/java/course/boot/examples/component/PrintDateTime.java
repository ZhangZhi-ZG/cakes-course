package course.boot.examples.component;

import course.boot.examples.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
@Component
public class PrintDateTime {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintDateTime.class);

    @Autowired
    private IOrderService orderService;

    // */5 * * * * *
    /**
     *
     */
    @Scheduled(cron = "*/5 * * * * *")
    public void printTime() {
        LOGGER.info("schedule print time = {}", LocalDateTime.now());

        // 以下是任务调度的业务逻辑代码处理
        orderService.createOrder("1234");
    }
}
