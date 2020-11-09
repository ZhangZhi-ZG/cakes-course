package course.mock.util;

public final class PathUtils {

    private PathUtils() {

    }

    public static String joinPath(String parent, String current) {
        return parent + "/" + current;
    }
}
