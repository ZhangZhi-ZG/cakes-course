package course.auto.framework.test;

import com.google.common.collect.Maps;
import course.auto.framework.model.TemplateInfo;
import course.auto.framework.template.TemplateFacade;
import course.auto.framework.template.factory.TemplateFactory;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class TestTemplate {

    @Test
    public void testTemp() {
        TemplateInfo templateInfo1 = TemplateFactory.of().getTemplateByKey("default_alarm_template");
        System.out.println("templateInfo = " + templateInfo1);

        TemplateInfo templateInfo2 = TemplateFactory.of().getTemplateByKey("default_report_template");
        System.out.println("templateInfo = " + templateInfo2);

        TemplateInfo templateInfo3 = TemplateFactory.of().getTemplateByKey("xxxxx");
        System.out.println("templateInfo = " + templateInfo3);
    }

    @Test
    public void testReplace() {
        HashMap<String, Object> mapping = Maps.newHashMap();
        mapping.put("case_title", "测试标题");
        mapping.put("case_id", "1234");
        mapping.put("case_owner", "qa");

        String text = TemplateFacade.replaceTemplate("default_alarm_template", mapping);
        System.out.println(text);
    }
}
