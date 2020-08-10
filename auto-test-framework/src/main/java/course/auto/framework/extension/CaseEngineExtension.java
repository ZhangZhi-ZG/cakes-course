package course.auto.framework.extension;

import course.auto.framework.annotation.CaseSelector;
import course.auto.framework.extension.engine.CaseGroupDiscoveryFilter;
import course.auto.framework.extension.engine.CaseTagDiscoveryFilter;
import course.auto.framework.util.RequiredUtils;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.PostDiscoveryFilter;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.lang.reflect.Method;


public class CaseEngineExtension implements BeforeTestExecutionCallback {

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        Method testMethod = context.getRequiredTestMethod();
        CaseSelector selector = invalidedSelector(testMethod.getAnnotation(CaseSelector.class));

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(DiscoverySelectors.selectPackage(selector.scanPackage()))
                .filters(new CaseTagDiscoveryFilter(selector),
                        new CaseGroupDiscoveryFilter(selector))
                .build();

        SummaryGeneratingListener listener = new SummaryGeneratingListener();

        LauncherFactory.create().execute(request, listener);

        TestExecutionSummary summary = listener.getSummary();

        System.out.println("summary.getTestsFoundCount() = " + summary.getTestsFoundCount());
        System.out.println("summary.getTestsAbortedCount() = " + summary.getTestsAbortedCount());
        System.out.println("summary.getTestsFailedCount() = " + summary.getTestsFailedCount());
        System.out.println("summary.getTestsSucceededCount() = " + summary.getTestsSucceededCount());
        System.out.println("summary.getTestsStartedCount() = " + summary.getTestsStartedCount());
        System.out.println("summary.getTestsSkippedCount() = " + summary.getTestsSkippedCount());
    }

    private CaseSelector invalidedSelector(CaseSelector selector) {
        RequiredUtils.requiredNotNull(selector, "case selector should not be null.");
        RequiredUtils.requireNotNullOrEmpty(selector.scanPackage(), "scan package should not be null or empty.");

        // TODO 判断,key 和 val 可以不写，但是如果写了，就一定都不能为空
        selector.key();
        selector.val();

        return selector;
    }
}
