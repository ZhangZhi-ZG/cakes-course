package course.auto.framework.alarm.callback;

import course.auto.framework.alarm.AlarmFacade;
import course.auto.framework.model.FailureResult;

public class DefaultAlarmCallback implements AlarmCallback {

    @Override
    public void postExecutionFailure(FailureResult failureResult) {
        AlarmFacade.doAlarm(failureResult);
    }
}
