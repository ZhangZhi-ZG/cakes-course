package course.mock.decorator;

import course.mock.util.RdmUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomIdDecorator extends BasePackResponseDecorator {

    private static final Pattern PATTERN = Pattern.compile("(?<=\\$\\{random:id:)(.*?)(?=\\})");

    public RandomIdDecorator(BasePackResponseDecorator innerDecorator) {
        super(innerDecorator);
    }

    @Override
    protected String onDecorate(String data) {
        Matcher matcher = PATTERN.matcher(data);
        while (matcher.find()) {
            int size = Integer.parseInt(matcher.group(0));
            String searchElement = genSearchElement(size);
            String id = RdmUtils.randomId(size);
            data = StringUtils.replace(data, searchElement, id);
        }
        return data;
    }

    private String genSearchElement(int size) {
        return String.format("${random:id:%d}", size);
    }
}
