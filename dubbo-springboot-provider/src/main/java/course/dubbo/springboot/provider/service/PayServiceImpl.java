package course.dubbo.springboot.provider.service;

import course.dubbo.pay.api.model.PayInfo;
import course.dubbo.pay.api.model.RetMsg;
import course.dubbo.pay.api.service.PayService;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@Service // 此时的Service不是Spring的Service,而是Dubbo的com.alibaba.dubbo.config.annotation.Service
//@Service(version = "1.0.0")
@DubboService
public class PayServiceImpl implements PayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayServiceImpl.class);

    @Override
    public RetMsg pay(PayInfo payInfo) {
        LOGGER.info("pay service start, payInfo={}", payInfo);
        return RetMsg.createSuccessMsg();
    }
}
