package course.mock.model;

import java.util.List;
import java.util.Map;

public class MockDataEntity {
    private String mappingHost;
    private List<Map<String, Object>> mappingParams;
    private String response;

    public String getMappingHost() {
        return mappingHost;
    }

    public void setMappingHost(String mappingHost) {
        this.mappingHost = mappingHost;
    }

    public List<Map<String, Object>> getMappingParams() {
        return mappingParams;
    }

    public void setMappingParams(List<Map<String, Object>> mappingParams) {
        this.mappingParams = mappingParams;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
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
