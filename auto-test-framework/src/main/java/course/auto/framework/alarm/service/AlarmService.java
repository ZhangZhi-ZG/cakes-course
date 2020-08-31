package course.auto.framework.alarm.service;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import course.auto.framework.annotation.CaseDesc;
import course.auto.framework.annotation.CaseTitle;
import course.auto.framework.annotation.CheckPoint;
import course.auto.framework.http.HttpFacade;
import course.auto.framework.model.FailureResult;
import course.auto.framework.template.TemplateFacade;
import course.auto.framework.util.ReflectUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AlarmService {

    public void doAlarm(FailureResult failureResult) {
        // 报警逻辑,此刻面临着2个问题
        // 1.用例标题,用例信息,用例xxx去哪获取
        // 2.获取后我们要发出报警,要具备一定的格式,要如何处理？ 直接拼凑？--- ok

        // 用例id : cccc
        // 用例标题: ccc
        // 用例xxx: cccc

        String title = null;
        String desc = null;
        String owner = null;
        List<String> checkPoints = null;
        String caseId = failureResult.getClassName() + "#" + failureResult.getMethodName();
        String reason = failureResult.getThrowable().getMessage();

        // 1.基于 className+methodName 用反射 获取到java.lang.reflect.Method
        Method testMethod = ReflectUtils.getMethod(failureResult.getClassName(), failureResult.getMethodName());
        boolean isCaseTitleSet = testMethod.isAnnotationPresent(CaseTitle.class);
        if (isCaseTitleSet) {
            CaseTitle caseTitle = testMethod.getAnnotation(CaseTitle.class);
            title = caseTitle.value();
        }

        // 2.
        boolean isCaseDescSet = testMethod.isAnnotationPresent(CaseDesc.class);
        if (isCaseDescSet) {
            CaseDesc caseDesc = testMethod.getAnnotation(CaseDesc.class);
            desc = caseDesc.desc();
            owner = caseDesc.owner();
        }

        // 3.
        CheckPoint[] ckps = testMethod.getAnnotationsByType(CheckPoint.class);
        checkPoints = Arrays.stream(ckps).map(CheckPoint::value).collect(Collectors.toList());

        // 4.封装

        Map<String, Object> alarmTemplateMapping = Maps.newHashMap();
        alarmTemplateMapping.put("case_title", title);
        alarmTemplateMapping.put("case_desc", desc);
        alarmTemplateMapping.put("case_id", caseId);
        alarmTemplateMapping.put("case_owner", owner);
        alarmTemplateMapping.put("case_ckps", Joiner.on(",").join(checkPoints));
        alarmTemplateMapping.put("failure_reason", reason);

        String text = TemplateFacade.replaceTemplate("default_alarm_template", alarmTemplateMapping);

//        {"msgtype": "text","text": {"content": "报警报告，哈哈哈哈哈哈哈"}}
        Map<String, Object> param = Maps.newHashMap();
        param.put("msgtype", "text");

        Map<String, Object> data = Maps.newHashMap();
        data.put("content", text);
        param.put("text", data);
        String response = HttpFacade.doPostJson(DING_TALK_ROOT_URL + failureResult.getToken(), param);
    }

    private static final String DING_TALK_ROOT_URL = "https://oapi.dingtalk.com/robot/send?access_token=";
}
