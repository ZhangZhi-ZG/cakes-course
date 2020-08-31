package course.auto.framework.test.cases.alarm;

import course.auto.framework.annotation.*;
import org.junit.jupiter.api.Assertions;

// @AlarmConfig(id="testAlarm",num=3)
public class TestAlarm {

    @AutoTest
    @CaseDesc(desc = "测试报警流程，本程序会出错导致报警被触发", owner = "张三111")
    @CaseTitle("报警能力测试1111")
    @CheckPoint("检查报警被触发")
    @CheckPoint("报警发出去")
    @CheckPoint("报警模板处理")
    @CaseTag(key = "xxx", val = "yyy")
    @CaseTag(key = "level", val = "P0")
    @CaseTag(key = "level", val = "P1")
    @CaseTag(key = "level", val = "P2")
    // @IgnoreAlarm
    // @AlarmConfig(ignore=true,)
    // @AlarmConfig(num=5,)
    public void testNormal() {
        System.out.println("TestAlarm.testNormal");
//        int i = 1 / 0;
        Assertions.assertEquals(1, 0);
    }

    @AutoTest
    @CaseDesc(desc = "测试报警流程，本程序会出错导致报警被触发", owner = "张三2222")
    @CaseTitle("报警能力测试22222")
    @CheckPoint("检查报警被触发")
    @CheckPoint("报警发出去")
    @CheckPoint("报警模板处理")
    @CaseTag(key = "xxx", val = "yyy")
    public void testNormal1111() {
        System.out.println("TestAlarm.testNormal");
//        int i = 1 / 0;
        Assertions.assertEquals(1, 10);
    }

    @AutoTest
    @CaseDesc(desc = "测试报警流程，本程序会出错导致报警被触发", owner = "张三33333")
    @CaseTitle("报警能力测试33333")
    @CheckPoint("检查报警被触发")
    @CheckPoint("报警发出去")
    @CheckPoint("报警模板处理")
    @CaseTag(key = "xxx", val = "yyy")
    public void testNormal112222() {
        System.out.println("TestAlarm.testNormal");
//        int i = 1 / 0;
        Assertions.assertEquals(2, 0);
    }
}
