package course.auto.framework.extension.format;

import com.google.common.collect.Lists;

import java.lang.reflect.Method;
import java.util.List;

public enum FormatManager {
    INSTANCE;

    private final List<FormatObserver> observers;

    FormatManager() {
        this.observers = Lists.newArrayList(new CaseTagFormatObserver(),
                new CheckPointFormatObserver(),
                new DingTalkFormatObserver(),
                new CaseDescFormatObserver(),
                new CaseTitleFormatObserver(),
                new CaseGroupFormatObserver());
    }

    public void doFormatCheck(Method testMethod) {
        for (FormatObserver observer : this.observers) {
            observer.format(testMethod);
        }
    }
}
