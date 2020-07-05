package zzhg.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zzhg.boot.Service.IOrderSerivce;

/**
 * @author zzhg
 * @date 2020-06-24
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger LOGGER =  LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private IOrderSerivce orderSerivce;

    @RequestMapping("/create")
    //RequestParam注解-要求参数必填
    public String createOrder(@RequestParam(value = "orderId", required = true) String orderId){
        LOGGER.info("create order for {}",orderId);
        Boolean isCreateOk = orderSerivce.createOrder(orderId);
        return isCreateOk? "success":"failed";
    }

}
