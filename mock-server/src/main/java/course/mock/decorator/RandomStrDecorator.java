package course.mock.decorator;

import course.mock.util.RdmUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomStrDecorator extends BasePackResponseDecorator {

    private static final Pattern PATTERN = Pattern.compile("(?<=\\$\\{random:str:)(.*?)(?=\\})");

    public RandomStrDecorator(BasePackResponseDecorator innerDecorator) {
        super(innerDecorator);
    }

    @Override
    protected String onDecorate(String data) {
        Matcher matcher = PATTERN.matcher(data);
        while (matcher.find()) {
            int size = Integer.parseInt(matcher.group(0));
            String searchElement = genSearchElement(size);
            String str = RdmUtils.randomStr(size);
            data = StringUtils.replace(data, searchElement, str);
        }
        return data;
    }

    private String genSearchElement(int size) {
        return String.format("${random:str:%d}", size);
    }
}
