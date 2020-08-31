package course.auto.framework.test.cases.run;

import course.auto.framework.alarm.callback.DefaultAlarmCallback;
import course.auto.framework.annotation.CaseSelector;
import course.auto.framework.annotation.DingTalkAlarm;
import course.auto.framework.annotation.ReportConfig;
import course.auto.framework.model.TokenConst;
import course.auto.framework.report.callback.DefaultReportCallback;

public class RunAlarmCases {

    @CaseSelector(scanPackage = "course.auto.framework.test.cases.alarm")
    @DingTalkAlarm(token = TokenConst.DEFAULT_TOKEN, callback = DefaultAlarmCallback.class)
    @ReportConfig(callback = DefaultReportCallback.class, token = TokenConst.DEFAULT_TOKEN)
    public void select1() {
        // exec_id = course.auto.framework.test.cases.run.RunAlarmCases.select1 + 121231231223(16)
    }
}
