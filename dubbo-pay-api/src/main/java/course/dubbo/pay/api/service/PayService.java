package course.dubbo.pay.api.service;

import course.dubbo.pay.api.model.PayInfo;
import course.dubbo.pay.api.model.RetMsg;

public interface PayService {

    RetMsg pay(PayInfo payInfo);
}
