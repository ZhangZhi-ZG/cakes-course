package course.mock.chain;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import course.mock.decorator.DecoratorManager;
import course.mock.model.MockContext;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;

public class SingletonMappingHandler extends AbstractHandler<MockContext, String> {

    @Override
    protected boolean preHandle(MockContext context) {
        return FileUtil.isFile(context.getMockFilePath());
    }

    @Override
    protected String onHandle(MockContext context) throws Exception {
        String response = IoUtil.read(new FileInputStream(new File(context.getMockFilePath())), Charset.defaultCharset());
        return DecoratorManager.newInstance.doPack(response);
    }
}
