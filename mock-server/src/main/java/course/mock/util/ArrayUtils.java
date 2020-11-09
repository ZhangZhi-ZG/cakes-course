package course.mock.util;

public final class ArrayUtils {

    public static String getFirstValue(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        return strArr[0];
    }
}
