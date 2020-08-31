package course.auto.framework.report.callback;

import course.auto.framework.model.SummaryResult;

public interface ReportCallback {

    void postExecutionSummary(SummaryResult summaryResult);
}
