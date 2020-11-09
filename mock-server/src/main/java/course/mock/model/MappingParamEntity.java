package course.mock.model;

import java.util.Map;

public class MappingParamEntity {
    private Map<String, Object> mappingParam;
    private Integer weight;

    public Map<String, Object> getMappingParam() {
        return mappingParam;
    }

    public void setMappingParam(Map<String, Object> mappingParam) {
        this.mappingParam = mappingParam;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "MappingParamEntity{" +
                "mappingParam=" + mappingParam +
                ", weight=" + weight +
                '}';
    }
}
