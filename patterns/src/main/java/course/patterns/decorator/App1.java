package course.patterns.decorator;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class App1 {
    public static void main(String[] args) {
        String str = "name=haha-randomStr(12), age=23+randomStr(2), info=xyz-randomId(3):-randomStr(5)";

        String resp = genStr(str);

        System.out.println("resp = " + resp);

    }

    private static String genStr(String str) {
        Pattern pattern1 = Pattern.compile("randomStr\\((.+?)\\)");
        Matcher matcher1 = pattern1.matcher(str);
        while (matcher1.find()) {
            String preReplaceElement = matcher1.group(0);
            String len = matcher1.group(1);
            String actulVal = RandomStringUtils.randomAlphabetic(Integer.parseInt(len));
            str = StringUtils.replace(str, preReplaceElement, actulVal);
        }

        Pattern pattern2 = Pattern.compile("randomId\\((.+?)\\)");
        Matcher matcher2 = pattern2.matcher(str);
        while (matcher2.find()) {
            String preReplaceElement = matcher2.group(0);
            String len = matcher2.group(1);
            String actulVal = RandomStringUtils.randomNumeric(Integer.parseInt(len));
            str = StringUtils.replace(str, preReplaceElement, actulVal);
        }

        return str;
    }


}
