package course.auto.framework.util;

import com.google.common.base.Strings;
import course.auto.framework.exception.RequiredException;

import java.util.Objects;

public final class RequiredUtils {
    private RequiredUtils() {

    }

    public static String requireNotNullOrEmpty(String str, String msg) {
        if (Strings.isNullOrEmpty(str)) {
            throw new RequiredException(msg);
        }

        return str;
    }

    public static Object requiredNotNull(Object obj, String msg) {
        if (Objects.isNull(obj)) {
            throw new RequiredException(msg);
        }

        return obj;
    }
}
