package course.auto.framework.test.cases.account;

import course.auto.framework.annotation.*;

/**
 * 创建交易
 */
public class TestAccount {

    @AutoTest
    @CaseTitle("xxx")
    @CaseDesc(desc = "xxx", owner = "xxx")
    @CheckPoint("ssss")
    @CaseTag(key = "project", val = "meituan")
    @CaseTag(key = "module", val = "pay")
    @CaseTag(key = "level", val = "redline")
    @CaseGroup(team = "abc", group = "123")
    public void test1() {
        System.out.println("account ... TestAccount.test1");
    }
}
