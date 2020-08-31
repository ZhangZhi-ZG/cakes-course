package course.auto.framework.test.cases.alarm;

import course.auto.framework.annotation.*;
import org.junit.jupiter.api.Assertions;

// @AlarmConfig(id="testAlarm",num=3)
public class TestAlarm222 {

    @AutoTest
    @CaseDesc(desc = "测试报警流程，本程序会出错导致报警被触发", owner = "张三111")
    @CaseTitle("报警能力测试1111")
    @CheckPoint("检查报警被触发")
    @CaseTag(key = "xxx", val = "yyy")
    public void testNormal() {
        System.out.println("TestAlarm222.testNormal");
    }

    @AutoTest
    @CaseDesc(desc = "测试报警流程，本程序会出错导致报警被触发", owner = "张三2222")
    @CaseTitle("报警能力测试22222")
    @CheckPoint("检查报警被触发")
    @CaseTag(key = "xxx", val = "yyy")
    public void testNormal1111() {
        System.out.println("TestAlarm222.testNormal");
    }

    @AutoTest
    @CaseDesc(desc = "测试报警流程，本程序会出错导致报警被触发", owner = "张三33333")
    @CaseTitle("报警能力测试33333")
    @CheckPoint("检查报警被触发")
    @CaseTag(key = "xxx", val = "yyy")
    public void testNormal112222() {
        System.out.println("TestAlarm222.testNormal");
    }
}
