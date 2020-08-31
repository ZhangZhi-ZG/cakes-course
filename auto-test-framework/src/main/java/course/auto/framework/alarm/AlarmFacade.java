package course.auto.framework.alarm;

import course.auto.framework.alarm.service.AlarmService;
import course.auto.framework.model.FailureResult;

public final class AlarmFacade {

    public static void doAlarm(FailureResult failureResult) {
        new AlarmService().doAlarm(failureResult);
    }
}
