package course.auto.framework.cases.order;

import course.auto.framework.annotation.*;

/**
 * 创建交易
 */
public class TestCreateOrder {

    @AutoTest
    @CaseTitle("xxx")
    @CaseDesc(desc = "xxx", owner = "xxx")
    @CheckPoint("ssss")
    @CaseTag(key = "project", val = "meituan")
    @CaseTag(key = "module", val = "pay")
    @CaseTag(key = "level", val = "redline")
    public void test1() {
        System.out.println("order ... TestCreateOrder.test1");
    }

    @AutoTest
    @CaseTitle("2222")
    @CaseDesc(desc = "2222", owner = "2222")
    @CheckPoint("222222")
    @CaseTag(key = "project", val = "toutiao")
    @CaseTag(key = "module", val = "pay")
    @CaseTag(key = "level", val = "normal")
    public void test2() {
        System.out.println("order ... TestCreateOrder.test2");
    }

    @AutoTest
    @CaseTitle("3333")
    @CaseDesc(desc = "3333", owner = "33333")
    @CheckPoint("333333")
    @CaseTag(key = "project", val = "toutiao")
    @CaseTag(key = "module", val = "pay")
    @CaseTag(key = "level", val = "redline")
    public void test3() {
        System.out.println("order ... TestCreateOrder.test3");
    }

    @AutoTest
    @CaseTitle("3333")
    @CaseDesc(desc = "3333", owner = "33333")
    @CheckPoint("333333")
    @CaseTag(key = "project", val = "toutiao")
    @CaseGroup(team = "xxxx", group = "xxxx")
    public void test4() {
        System.out.println("TestCreateOrder.test4");
    }
}
