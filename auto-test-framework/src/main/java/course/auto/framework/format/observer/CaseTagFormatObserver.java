package course.auto.framework.format.observer;

import course.auto.framework.annotation.CaseTag;
import course.auto.framework.exception.IllegalFormatException;
import course.auto.framework.format.FormatObserver;
import course.auto.framework.util.RequiredUtils;

import java.lang.reflect.Method;

public class CaseTagFormatObserver implements FormatObserver {

    @Override
    public void format(Method testMethod) {
        CaseTag[] tags = testMethod.getAnnotationsByType(CaseTag.class);
        if (tags.length == 0) {
            throw new IllegalFormatException("@CaseTag should be set, eg: @CaseTag(key = \"project\", val = \"meituan\")");
        }

        for (CaseTag tag : tags) {
            RequiredUtils.requireNotNullOrEmpty(tag.key(), "CaseTag 'key' should not be null or empty");
            RequiredUtils.requireNotNullOrEmpty(tag.val(), "CaseTag 'val' should not be null or empty");
        }
    }
}
