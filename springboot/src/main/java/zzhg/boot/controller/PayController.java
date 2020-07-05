package zzhg.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzhg
 * @date 2020-06-27
 */

@RestController
@RequestMapping("/pay")
public class PayController {

    private static final Logger LOGGER =  LoggerFactory.getLogger(PayController.class);

    @RequestMapping("/pay1")
    //RequestParam注解-规定哪些参数是必传的,defaultValue可以设置参数默认值
    public String pay1(@RequestParam(value = "payId",required = true,defaultValue = "haha") String payId){

        LOGGER.info("pay1 start..payId={}",payId);

        return "pay1:success";
    }
}
