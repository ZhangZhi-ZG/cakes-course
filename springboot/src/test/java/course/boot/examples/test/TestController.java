package course.boot.examples.test;

import course.boot.examples.controller.PayController;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private PayController controller;

    @Before
    public void before() {
        LOGGER.info("before start");
    }

    @BeforeClass
    public static void beforeClass() {
        LOGGER.info("beforeClass start");
    }

    @Test
    public void testPay4() {
        String resp = controller.pay4("123456789");
        System.out.println("resp = " + resp);
    }

    @Test
    public void testPay5() {
        // TODO
    }

    @Test
    public void test111() {
        LOGGER.info("exec test 1111");
    }

    @After
    public void after() {
        LOGGER.info("after start");
    }

    @AfterClass
    public static void afterClass() {
        LOGGER.info("afterClass start");
    }
}
