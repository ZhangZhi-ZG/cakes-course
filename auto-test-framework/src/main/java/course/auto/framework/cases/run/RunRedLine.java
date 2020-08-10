package course.auto.framework.cases.run;

import course.auto.framework.annotation.CaseSelector;
import course.auto.framework.extension.engine.CaseGroupDiscoveryFilter;
import course.auto.framework.extension.engine.CaseTagDiscoveryFilter;
import org.junit.Test;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

public class RunRedLine {

    //    @CaseSelector(scanPackage = "course.auto.framework.cases.pay", key = "level", val = "redline")
    @CaseSelector(scanPackage = "course.auto.framework.cases.pay", key = "level", val = "redline")
    public void runPayRedLine() {
        //
    }

    //    @Report(type="dingtalk")
    @CaseSelector(scanPackage = "course.auto.framework.cases.account", team = "abc", group = "123")
    // , title="嘻嘻嘻嘻嘻嘻嘻嘻寻"
    public void runGroup() {
//        new CaseGroupDiscoveryFilter(selector)
    }

    // To 蹭课-耿宗源  17:32:34: 老师我有个问题一直想问，咱们为啥选择junit注解驱动测试用例
//    @Test
//    public void runGroup2222() {
//        CaseSelectInfo info  = CaseSelectBuilder.builder()
//                .packageName("xxxx")
//                .key("xxx")
//                .val("xxx")
//                .build();
//
//    }
//
//    public void xxxxc(CaseSelectInfo info){
//        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
//                .selectors(DiscoverySelectors.selectPackage(info.getPackageName))
//                .filters(new CaseTagDiscoveryFilter(selector),
//                        new CaseGroupDiscoveryFilter(selector))
//                .build();
//
//        SummaryGeneratingListener listener = new SummaryGeneratingListener();
//    }
}
