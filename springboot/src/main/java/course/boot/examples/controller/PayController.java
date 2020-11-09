package course.boot.examples.controller;

import com.google.common.base.Strings;
import course.boot.examples.bean.PayInfo;
import course.boot.examples.bean.RetMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayController.class);

    @RequestMapping("pay1")
    public String pay1(String payId) {

        LOGGER.info("pay1 start. payId={}", payId);

        try {
            if (Strings.isNullOrEmpty(payId)) {
                throw new IllegalArgumentException("payId should not be null");
            }
            return "pay1:success";
        } catch (Exception e) {
            return "pay1:failed == " + e.getMessage();
        }
    }

    @RequestMapping("pay2")
    /**
     * RequestParam: required=“True”代表该参数为必传
     */
    public String pay2(@RequestParam(value = "payId", required = true) String payId) {

        LOGGER.info("pay2 start. payId={}", payId);

        return "pay2:success";
    }

    @RequestMapping("pay3")
    //RequestParam注解-规定哪些参数是必传的,defaultValue可以设置参数默认值
    public String pay3(@RequestParam(value = "payId", required = false, defaultValue = "hahahah-12345") String payId) {

        LOGGER.info("pay3 start. payId={}", payId);

        return "pay3:success";
    }

    @RequestMapping("pay4/{id}")
    public String pay4(@PathVariable("id") String id) {

        LOGGER.info("pay4 start. payId={}", id);
        return "pay4:success";
    }

    // @ResponseBody  使用@RestController标识后，此注解可省略
    //method-请求方法，consumes-请求的文本类型
    @RequestMapping(value = "pay5", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RetMsg pay5(@RequestBody PayInfo payInfo) {
        LOGGER.info("pay5 start. payInfo={}", payInfo);
        return RetMsg.buildSuccessMsg("pay success.");
    }
}
