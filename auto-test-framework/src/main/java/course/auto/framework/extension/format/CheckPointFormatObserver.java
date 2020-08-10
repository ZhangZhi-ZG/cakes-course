package course.auto.framework.extension.format;

import course.auto.framework.annotation.CheckPoint;
import course.auto.framework.exception.IllegalFormatException;
import course.auto.framework.util.RequiredUtils;

import java.lang.reflect.Method;

public class CheckPointFormatObserver implements FormatObserver {

    @Override
    public void format(Method testMethod) {
        CheckPoint[] checkPoints = testMethod.getAnnotationsByType(CheckPoint.class);
        if (checkPoints.length == 0) {
            throw new IllegalFormatException("@CheckPoint should be set, eg: @CheckPoint(\"检查点\")");
        }

        for (CheckPoint checkPoint : checkPoints) {
            RequiredUtils.requireNotNullOrEmpty(checkPoint.value(), "CheckPoint 'value' should not be null or empty");
        }
    }
}
