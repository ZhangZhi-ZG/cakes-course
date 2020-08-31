package course.auto.framework.alarm.callback;

import course.auto.framework.model.FailureResult;

public interface AlarmCallback {

    void postExecutionFailure(FailureResult failureResult);
}
