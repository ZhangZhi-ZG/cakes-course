package course.mock.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.google.common.base.Strings;
import course.mock.model.MockDataEntity;
import course.mock.model.MappingParamEntity;
import course.mock.model.MockDataInfo;
import course.mock.model.MockContext;
import course.mock.util.YmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@RestController
public class MockController1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockController1.class);

    private static final String ROOT_PATH = "/Users/haoc/course/mock-data/";

    @Autowired
    private HttpServletRequest request;

    //    @RequestMapping("/**")
    public String doMock() throws FileNotFoundException {
        // 1.拿到uri
        // 2.拿到参数
        // 3.拿到请求的ip地址
        MockContext mockContext = MockContext.newContext()
                .setRequestUri(request.getRequestURI())
                .setRequestIp(request.getRemoteHost())
                .setRequestParams(parseRequestParam());

        LOGGER.info("do mock start, context={}", mockContext);

        // 4.到指定的mock数据目录下去查找匹配到的mock数据
        //  - 4.1 解析文件,然后按照参数和IP去进行匹配,并且每个匹配节点都有权重,默认=1
        //  - 4.2 计算权重,大的那个返回

        // 基于uri获取目录下的指定文件,并判断其属性,是目录，还是文件
        // 如果是文件，直接返回了，如果是目录需要解析匹配
        String filePath = ROOT_PATH + mockContext.getMockFileName();
        File mockDataFile = new File(filePath);

        if (mockDataFile.isFile()) {
            // 直接返回
            return IoUtil.read(new FileInputStream(new File(filePath)), Charset.defaultCharset());
        }

        // accountId:123,id:111 => accountId=123, id=111
        List<String> requestParamList = mockContext.getRequestParams().entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.toList());

        // 此时就需要去解析出所有文件,然后计算匹配,计算权重,找到最大的,然后返回
        List<String> mockDataFileNames = FileUtil.listFileNames(filePath);
        int weightResult = 0;
        String response = null;
        // 遍历所有mock数据,然后进行计算权重
        for (String fileName : mockDataFileNames) {
            String path = filePath + "/" + fileName;
            // 获取出文件中的mock数据
            MockDataInfo mockDataInfo = MockDataInfo.fromMappingParamData(YmlUtils.readForObject(path, MockDataEntity.class));

            // 开始做匹配
            List<MappingParamEntity> mappingParamEntities = mockDataInfo.getMappingParams();
            int weightSum = 0;
            // 遍历每个mock文件中的 所有参数匹配项,然后累加权重进行计算
            for (MappingParamEntity paramEntity : mappingParamEntities) {
                Map<String, Object> paramMap = paramEntity.getMappingParam();
                String param = paramMap.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).findFirst().get();
                // 如果参数匹配到了， 就将权重做累加
                if (requestParamList.contains(param)) {
                    Integer weight = paramEntity.getWeight();
                    weightSum += weight;
                }
            }

            // 判断,找最大的权重值,如果当前计算出来的比之前的大，就覆盖
            if (weightSum > weightResult) {
                response = mockDataInfo.getResponse();
                weightResult = weightSum;
            }
        }

        if (Strings.isNullOrEmpty(response)) {
            return "mock none response!!!";
        }

        //

        return response;
    }

    private Map<String, String> parseRequestParam() {
        return this.request.getParameterMap()
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> getFirstValue(entry.getValue())));
    }

    private String getFirstValue(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        return strArr[0];
    }
}
