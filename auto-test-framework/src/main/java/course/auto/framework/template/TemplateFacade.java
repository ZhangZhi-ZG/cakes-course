package course.auto.framework.template;

import course.auto.framework.model.TemplateInfo;
import course.auto.framework.template.service.TemplateService;

import java.util.Map;

public final class TemplateFacade {

    private TemplateFacade() {
        //
    }

    public static TemplateInfo getTemplateByKey(String templateKey) {
        return new TemplateService().getTemplateByKey(templateKey);
    }

    public static String replaceTemplate(String templateKey, Map<String, Object> mapping) {
        return new TemplateService().replaceTemplate(templateKey, mapping);
    }
}
