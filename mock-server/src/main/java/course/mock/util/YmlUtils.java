package course.mock.util;

import cn.hutool.core.io.IoUtil;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public final class YmlUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(YmlUtils.class);

    private static final ObjectMapper MAPPER;

    private YmlUtils() {

    }

    static {
        YAMLFactory factory = new YAMLFactory();
        YAMLMapper mapper = new YAMLMapper(factory);
        MAPPER = mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    }

    public static Map<String, String> readForMap(String path) {
        Map<String, String> map = Maps.newHashMap();
        try {
            InputStream ins = Resources.getResource(path).openStream();
            JsonNode rootNode = MAPPER.readTree(ins);
            rootNode.fields().forEachRemaining(e -> map.put(e.getKey(), e.getValue().asText()));
            return map;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static <T> T readForObject(String path, Class<T> clazz) {
        try {
            LOGGER.info("read for path = {}", path);
            InputStream ins = IoUtil.toStream(new File(path));
            return MAPPER.readValue(ins, clazz);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

//    public static void main(String[] args) {
//        // MappingParamInfo{mappingHost='123.123.123.1', mappingParams=[MappingParamEntity{mappingParam={accountId=4567, accountName=zhangsan}, weight=2}], response='{"errNo":500,"errMsg":"failed"}'}
//        MappingParamData paramData = readForObject("/Users/haoc/course/mock-data/create_acount/wangwu-ali-processing.yml", MappingParamData.class);
//        MappingParamInfo paramInfo = MappingParamInfo.fromMappingParamData(paramData);
//        System.out.println("paramInfo = " + paramInfo);
//    }
}
