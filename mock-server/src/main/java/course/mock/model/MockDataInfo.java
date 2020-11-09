package course.mock.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MockDataInfo {
    private String mappingHost;
    private List<MappingParamEntity> mappingParams;
    private String response;

    public static MockDataInfo fromMappingParamData(MockDataEntity paramData) {
        MockDataInfo paramInfo = new MockDataInfo();
        paramInfo.mappingHost = paramData.getMappingHost();
        paramInfo.response = paramData.getResponse();
        paramInfo.mappingParams = paramData.getMappingParams()
                .stream().map(m -> {
                    int weight = 1;
                    Object weightVal = m.remove("weight");
                    if (!Objects.isNull(weightVal)) {
                        weight = Integer.parseInt(weightVal.toString());
                    }

                    MappingParamEntity paramEntity = new MappingParamEntity();
                    paramEntity.setWeight(weight);
                    paramEntity.setMappingParam(m);
                    return paramEntity;
                }).collect(Collectors.toList());

        return paramInfo;
    }

    public String getMappingHost() {
        return mappingHost;
    }

    public List<MappingParamEntity> getMappingParams() {
        return mappingParams;
    }

    public String getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "MappingParamInfo{" +
                "mappingHost='" + mappingHost + '\'' +
                ", mappingParams=" + mappingParams +
                ", response='" + response + '\'' +
                '}';
    }
}
