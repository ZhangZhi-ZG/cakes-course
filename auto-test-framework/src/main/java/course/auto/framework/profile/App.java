package course.auto.framework.profile;

import course.auto.framework.annotation.*;
import course.auto.framework.dac.factory.DataSourceFactory;

import javax.sql.DataSource;

@EnvProfile("abc")
public class App {

    @AutoTest
    @CheckPoint("xxx")
    @CaseTitle("xxxx")
    @CaseDesc(desc = "wwwww", owner = "qa")
    @CaseTag(key = "xxx", val = "xxx")
    @EnvProfile("abc") // 临时加，切换环境。
    public void testNormal() {
        // 1.EnvProfile来标注我们希望当前用例运行时的profile信息
        // 2.基于junit5来做扩展，在用例运行前，将此Profile的数据 塞进一个全局信息中。
        // 3.后续需要来用profile切换时，从此全局信息中捞出来具体profile是啥
        // 4.为保配置读取失败，可以设置一个兜底的，如config-default.yml

        // 5.思考： 如果每个用例都写一个profile，我们的profile难道每次都改？
    }

    @AutoTest
    @CheckPoint("xxx")
    @CaseTitle("xxxx")
    @CaseDesc(desc = "wwwww", owner = "qa")
    @CaseTag(key = "xxx", val = "xxx")
    public void testNormal1() {
        DataSource dataSource = DataSourceFactory.of().getDataSource();
        System.out.println("dataSource = " + dataSource);
    }
}
