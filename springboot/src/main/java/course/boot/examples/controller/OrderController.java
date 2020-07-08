package course.boot.examples.controller;

import course.boot.examples.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
//与Controller相比，RestController会返回处理后的响应结果，不需要我们自己对响应结果进行处理
@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/create")
    public String createOrder(String orderId) {
        LOGGER.info("create order start. orderId={}", orderId); // mq => kafka => 日志平台
        // sso -> userId -> userId+url => redis  pv/uv
        try {
            Boolean isCreateOk = orderService.createOrder(orderId);

            return isCreateOk ? "success" : "failed";
        } catch (Exception e) {
            LOGGER.error("xxxx occur error.", e);
            return "info=" + e.getMessage();
        }
    }
}
