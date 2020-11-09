package course.mock.chain;

import cn.hutool.core.io.FileUtil;
import course.mock.model.MockContext;
import course.mock.observer.ObserverManager;

public class MultipleMappingHandler extends AbstractHandler<MockContext, String> {

    @Override
    protected boolean preHandle(MockContext context) {
        return FileUtil.isDirectory(context.getMockFilePath());
    }

    @Override
    protected String onHandle(MockContext context) {
        return ObserverManager.newInstance.getMockData(context);
    }
}
