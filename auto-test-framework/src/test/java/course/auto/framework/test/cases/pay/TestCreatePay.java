package course.auto.framework.test.cases.pay;

import course.auto.framework.annotation.*;

/**
 * 创建交易
 */
public class TestCreatePay {

    @AutoTest
    @CaseTitle("xxx")
    @CaseDesc(desc = "xxx", owner = "xxx")
    @CheckPoint("ssss")
    @CaseTag(key = "project", val = "meituan")
    @CaseTag(key = "module", val = "pay")
    @CaseTag(key = "level", val = "redline")
    public void test1() {
        System.out.println("pay ... TestCreatePay.test1 redline");
    }

    @AutoTest
    @CaseTitle("2222")
    @CaseDesc(desc = "2222", owner = "2222")
    @CheckPoint("222222")
    @CaseTag(key = "project", val = "toutiao")
    @CaseTag(key = "module", val = "pay")
    @CaseTag(key = "level", val = "normal")
    public void test2() {
        System.out.println("pay ... TestCreatePay.test2 normal");
    }

    @AutoTest
    @CaseTitle("3333")
    @CaseDesc(desc = "3333", owner = "33333")
    @CheckPoint("333333")
    @CaseTag(key = "project", val = "toutiao")
    @CaseTag(key = "module", val = "pay")
    @CaseTag(key = "level", val = "redline")
    @CaseTag(key = "team", val = "abc")
    @CaseTag(key = "group", val = "123")
//    @CaseProject(project = "", module = "")
//    @CaseGroup(team = "", group = "")
    public void test3() {
        System.out.println("pay ... TestCreatePay.test3 redline");
    }


    @AutoTest
    @CaseTitle("xxx")
    @CaseDesc(desc = "xxx", owner = "xxx")
    @CheckPoint("ssss")
    @CaseTag(key = "project", val = "meituan")
    @CaseTag(key = "module", val = "pay")
    @CaseTag(key = "level", val = "redline")
    public void test4() {
        System.out.println("pay ... TestCreatePay.test4 redline");
    }

    @AutoTest
    @CaseTitle("xxx")
    @CaseDesc(desc = "xxx", owner = "xxx")
    @CheckPoint("ssss")
    @CaseTag(key = "project", val = "meituan")
    @CaseTag(key = "module", val = "pay")
    @CaseTag(key = "level", val = "redline")
    public void test5() {
        System.out.println("pay ... TestCreatePay.test5 redline");
    }

    @AutoTest
    @CaseTitle("xxx")
    @CaseDesc(desc = "xxx", owner = "xxx")
    @CheckPoint("ssss")
    @CaseTag(key = "project", val = "meituan")
    @CaseTag(key = "module", val = "pay")
    @CaseTag(key = "level", val = "redline")
    public void test6() {
        System.out.println("pay ... TestCreatePay.test6 redline");
        int i = 1 / 0;
    }
}
