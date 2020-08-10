package course.dubbo.springboot.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import course.dubbo.pay.api.model.PayInfo;
import course.dubbo.pay.api.model.RetMsg;
import course.dubbo.pay.api.service.PayService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PayController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayController.class);

    @DubboReference
    private PayService payService;

    @RequestMapping("/create")
    public RetMsg createPay(@RequestParam("transId") String transId, @RequestParam("amount") Integer amount) {
        LOGGER.info("create pay start. transId={} amount={}", transId, amount);

        PayInfo payInfo = new PayInfo();
        payInfo.setTransId(transId);
        payInfo.setAmount(amount);
        return payService.pay(payInfo);
    }
}
