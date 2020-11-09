package course.mock.observer;

import cn.hutool.core.io.FileUtil;
import course.mock.model.MockDataEntity;
import course.mock.model.MockDataInfo;
import course.mock.model.MockContext;
import course.mock.util.PathUtils;
import course.mock.util.YmlUtils;

import java.util.List;
import java.util.stream.Collectors;

public class LoadMockFilesObserver implements IObserver<MockContext> {

    @Override
    public void update(MockContext context) {
        List<MockDataInfo> mockDataInfoList = FileUtil.listFileNames(context.getMockFilePath())
                .parallelStream()
                .map(fileName -> {
                    String path = PathUtils.joinPath(context.getMockFilePath(), fileName);
                    return MockDataInfo.fromMappingParamData(YmlUtils.readForObject(path, MockDataEntity.class));
                }).collect(Collectors.toList());

        context.setMockDataInfoList(mockDataInfoList);
    }
}
