package course.schema.sync.util;

import java.util.List;
import java.util.Objects;

/**
 * author: heiha
 */
public class ListUtils {

    public static <T> boolean isContains(List<T> list, T t) {
        if (Objects.isNull(list) || Objects.isNull(t)) {
            return false;
        }
        return list.contains(t);
    }
}
