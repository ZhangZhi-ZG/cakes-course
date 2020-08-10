package course.auto.framework.extension.engine;

import course.auto.framework.annotation.CaseGroup;
import course.auto.framework.annotation.CaseSelector;
import course.auto.framework.annotation.CaseTag;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;
import org.junit.platform.engine.FilterResult;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.launcher.PostDiscoveryFilter;

import java.lang.reflect.Method;
import java.util.Arrays;

public class CaseGroupDiscoveryFilter extends AbstractDiscoveryFilter {

    public CaseGroupDiscoveryFilter(CaseSelector selector) {
        super(selector);
    }

    @Override
    protected boolean preFilter(CaseSelector selector) {
        return StringUtils.isNotBlank(selector.team()) && StringUtils.isNotBlank(selector.group());
    }

    @Override
    protected FilterResult onApply(TestMethodTestDescriptor descriptor) {
        Method testMethod = descriptor.getTestMethod();

        boolean isCaseGroupSet = testMethod.isAnnotationPresent(CaseGroup.class);
        if (!isCaseGroupSet) {
            return FilterResult.includedIf(false);
        }

        CaseGroup caseGroup = testMethod.getAnnotation(CaseGroup.class);
        if (selector.team().equals(caseGroup.team()) && selector.group().equals(caseGroup.group())) {
            return FilterResult.includedIf(true);
        }

        return FilterResult.includedIf(false);
    }

}
