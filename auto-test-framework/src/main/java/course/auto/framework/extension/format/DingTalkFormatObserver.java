package course.auto.framework.extension.format;

import course.auto.framework.annotation.CheckPoint;
import course.auto.framework.annotation.DingTalkAlarm;
import course.auto.framework.exception.IllegalFormatException;
import course.auto.framework.util.RequiredUtils;

import java.lang.reflect.Method;

public class DingTalkFormatObserver implements FormatObserver {

    @Override
    public void format(Method testMethod) {
        boolean isDingTalkAlarmSet = testMethod.isAnnotationPresent(DingTalkAlarm.class);
        if (!isDingTalkAlarmSet) {
            return;
        }

        DingTalkAlarm dingTalkAlarm = testMethod.getAnnotation(DingTalkAlarm.class);
        RequiredUtils.requireNotNullOrEmpty(dingTalkAlarm.token(), "DingTalkAlarm 'token' should not be null or empty");
    }
}
