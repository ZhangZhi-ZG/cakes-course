package course.schema.sync.util;

import com.google.common.base.Strings;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public final class VerifyUtils {
    private VerifyUtils() {
        //
    }

    public static void requiredNotNullOrEmpty(String str, String msg) {
        if (Strings.isNullOrEmpty(str)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void requiredAllNotNullOrEmpty(String... str) {
        for (String s : str) {
            requiredNotNullOrEmpty(s, "should not be null or empty");
        }
    }
}
