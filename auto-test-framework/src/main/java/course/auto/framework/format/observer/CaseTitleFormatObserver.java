package course.auto.framework.format.observer;

import course.auto.framework.annotation.CaseTitle;
import course.auto.framework.exception.IllegalFormatException;
import course.auto.framework.format.FormatObserver;
import course.auto.framework.util.RequiredUtils;

import java.lang.reflect.Method;

public class CaseTitleFormatObserver implements FormatObserver {

    @Override
    public void format(Method testMethod) {
        boolean isCaseTitleSet = testMethod.isAnnotationPresent(CaseTitle.class);
        if (!isCaseTitleSet) {
            throw new IllegalFormatException("@CaseTitle should be set, eg: @CaseTitle(\"说清楚这个case是干啥的\")");
        }

        CaseTitle title = testMethod.getAnnotation(CaseTitle.class);
        RequiredUtils.requireNotNullOrEmpty(title.value(), "CaseTitle 'value' should not be null or empty");
    }
}
