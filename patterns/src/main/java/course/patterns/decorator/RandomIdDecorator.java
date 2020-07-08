package course.patterns.decorator;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class RandomIdDecorator extends AbstractDecorator {

    private static final Pattern PATTERN = Pattern.compile("randomId\\((.+?)\\)");

    public RandomIdDecorator(AbstractDecorator decorator) {
        super(decorator);
    }

    @Override
    protected String onDecorate(String str) {
        Matcher matcher = PATTERN.matcher(str);
        while (matcher.find()) {
            String preReplaceElement = matcher.group(0);
            String len = matcher.group(1);
            String actulVal = RandomStringUtils.randomNumeric(Integer.parseInt(len));
            str = StringUtils.replace(str, preReplaceElement, actulVal);
        }
        return str;
    }
}
