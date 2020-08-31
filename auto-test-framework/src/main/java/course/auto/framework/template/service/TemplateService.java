package course.auto.framework.template.service;

import course.auto.framework.model.TemplateInfo;
import course.auto.framework.template.factory.TemplateFactory;
import course.auto.framework.util.RequiredUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Formatter;
import java.util.Map;

public class TemplateService {

    public TemplateInfo getTemplateByKey(String templateKey) {
        RequiredUtils.requireNotNullOrEmpty(templateKey, "template key should not be null or empty.");
        return TemplateFactory.of().getTemplateByKey(templateKey);
    }

    public String replaceTemplate(String templateKey, Map<String, Object> mapping) {
        TemplateInfo templateInfo = getTemplateByKey(templateKey);
        String templateValue = templateInfo.getTemplateValue();

        for (Map.Entry<String, Object> entry : mapping.entrySet()) {
            templateValue = StringUtils.replace(templateValue, createTemplateKey(entry.getKey()), String.valueOf(entry.getValue()));
        }

        return templateValue;
    }

    // ${key}
    private String createTemplateKey(String key) {
        return new Formatter().format("${%s}", key).toString();
    }
}
