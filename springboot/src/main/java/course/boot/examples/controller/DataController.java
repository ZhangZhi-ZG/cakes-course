package course.boot.examples.controller;

import course.boot.examples.bean.DbConfigInfo;
import course.boot.examples.bean.PayInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
@RestController
@RequestMapping("/data")
public class DataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataController.class);

    // @Value("${dd.name}") // SpEL 表达式
    // private String ddName;

    @Autowired
    private PayInfo payInfo;

    @Resource
    private DbConfigInfo dbConfigInfo;

    @RequestMapping("/d1")
    public String data1() {
        return "data1 resp:";
    }

    @RequestMapping("/d2")
    public PayInfo data2() {
        LOGGER.info("data 2 start. payInfo={}", payInfo);
        return payInfo;
    }

    @RequestMapping("/d3")
    public DbConfigInfo data3() {
        LOGGER.info("data 3 start. dbConfigInfo={}", dbConfigInfo);
        return dbConfigInfo;
    }
}
