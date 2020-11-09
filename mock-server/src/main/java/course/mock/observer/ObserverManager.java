package course.mock.observer;

import com.google.common.collect.Lists;
import course.mock.model.MockContext;

import java.util.List;

public enum ObserverManager {
    newInstance;

    private final List<IObserver<MockContext>> observers;

    ObserverManager() {
        // 1.加载本地的mock文件,将其数据转化成我们需要的对象类型
        // 2.基于请求的参数集合来计算第1步当中所有匹配的数据的权重加和
        // 3.处理数据...
        this.observers = Lists.newArrayList(
                new LoadMockFilesObserver(), // 第一步加载本地mock文件并解析成我们需要的数据模型
                new CalcWeightObserver(),   // 第二步计算权重,找到最大的那个
                new PackResponseObserver()
        );
    }

    public String getMockData(MockContext context) {
        for (IObserver<MockContext> observer : this.observers) {
            observer.update(context);
        }
        return context.getFinalResponse();
    }
}
