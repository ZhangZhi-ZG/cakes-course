package course.boot.examples.test;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
public class TestUnitDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestUnitDemo.class);

    @Before
    public void before() {
        LOGGER.info("before start");
    }

    @BeforeClass
    public static void beforeClass() {
        LOGGER.info("beforeClass start");
    }

    @Test
    public void test2222() {
        LOGGER.info("exec test 2222");
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
