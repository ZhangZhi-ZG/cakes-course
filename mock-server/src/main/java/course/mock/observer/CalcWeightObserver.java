package course.mock.observer;

import com.google.common.base.Strings;
import course.mock.model.MappingParamEntity;
import course.mock.model.MockContext;
import course.mock.model.MockDataInfo;

import java.util.List;
import java.util.Map;

public class CalcWeightObserver implements IObserver<MockContext> {

    @Override
    public void update(MockContext context) {
        List<MockDataInfo> mockDataInfoList = context.getMockDataInfoList();

        // 这里还是有些恶心,真正想处理的可以用流式处理来并行计算,但是可读性不一定高。
        // 拆出去，就是将内部的方法 进行一定的小范围的迁移
        int maxWeight = 0;
        String response = null;
        for (MockDataInfo mockData : mockDataInfoList) {
            List<MappingParamEntity> mappingParamEntities = mockData.getMappingParams();
            int weightSum = 0;

            for (MappingParamEntity paramEntity : mappingParamEntities) {
                Map<String, Object> paramMap = paramEntity.getMappingParam();
                String param = paramMap.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).findFirst().get();
                if (context.getRequestParamEntities().contains(param)) {
                    Integer weight = paramEntity.getWeight();
                    weightSum += weight;
                }
            }

            if (weightSum > maxWeight) {
                response = mockData.getResponse();
                maxWeight = weightSum;
            }
        }

        if (Strings.isNullOrEmpty(response)) {
            throw new IllegalStateException("nothing mapping");
        }

        // 回写,
        context.setFinalResponse(response);
    }
}
