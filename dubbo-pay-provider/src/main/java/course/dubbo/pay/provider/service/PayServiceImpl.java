package course.dubbo.pay.provider.service;

import course.dubbo.pay.api.model.PayInfo;
import course.dubbo.pay.api.model.RetMsg;
import course.dubbo.pay.api.service.PayService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PayServiceImpl implements PayService {

    @Override
    public RetMsg pay(PayInfo payInfo) {
        String start = formatTime(LocalDateTime.now());
        System.out.println("PayServiceImpl.pay start time = " + start);

        sleep(2100);

        String end = formatTime(LocalDateTime.now());
        System.out.println("PayServiceImpl.pay end time = " + end);
        return RetMsg.createSuccessMsg();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String formatTime(LocalDateTime dateTime) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime);
    }
}
