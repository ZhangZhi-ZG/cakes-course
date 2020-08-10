package course.auto.framework.annotation;

import course.auto.framework.extension.CaseFormatExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(CaseFormatExtension.class)
@Test
public @interface AutoTest {
}
