package course.auto.framework.annotation;

import course.auto.framework.format.observer.CaseFormatExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(CaseFormatExtension.class) // 第二步，指定要扩展的类，其实现自 BeforeTestExecutionCallback
@Test
public @interface AutoTest {
}
