package course.mock.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class RdmUtils {

    public static String random32Id() {
        // 14
        String time = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());

        String firstPoint = RandomStringUtils.randomAlphanumeric(9);

        String secondPoint = RandomStringUtils.randomNumeric(7);

        return String.format("%s_%s_%s", time, firstPoint, secondPoint);
    }

    public static String randomId(int size) {
        return RandomStringUtils.randomNumeric(size);
    }

    public static String randomStr(int size) {
        return RandomStringUtils.randomAlphabetic(size);
    }

    public static void main(String[] args) {
        System.out.println("random32Id() = " + random32Id());
    }

}
