package course.mock.model;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MockContext {
    private String requestUri;
    private Map<String, String> requestParams;
    private String requestIp;
    private String finalResponse;
    private List<MockDataInfo> mockDataInfoList;

    private MockContext() {

    }

    public List<String> getRequestParamEntities() {
        return requestParams.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.toList());
    }

    public static MockContext newContext() {
        return new MockContext();
    }

    public MockContext setRequestUri(String requestUri) {
        this.requestUri = requestUri;
        return this;
    }

    public MockContext setRequestParams(Map<String, String> requestParams) {
        this.requestParams = requestParams;
        return this;
    }

    public MockContext setRequestIp(String requestIp) {
        this.requestIp = requestIp;
        return this;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public Map<String, String> getRequestParams() {
        return requestParams;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public String getMockFileName() {
        String var1 = StringUtils.substringAfter(this.requestUri, "/");
        return StringUtils.replace(var1, "/", "_");
    }

    public String getMockFilePath() {
        return MockConst.ROOT_PATH + getMockFileName();
    }

    public String getFinalResponse() {
        return finalResponse;
    }

    public void setFinalResponse(String finalResponse) {
        this.finalResponse = finalResponse;
    }

    public List<MockDataInfo> getMockDataInfoList() {
        return mockDataInfoList;
    }

    public void setMockDataInfoList(List<MockDataInfo> mockDataInfoList) {
        this.mockDataInfoList = mockDataInfoList;
    }

    @Override
    public String toString() {
        return "MockContext{" +
                "requestUri='" + requestUri + '\'' +
                ", requestParams=" + requestParams +
                ", requestIp='" + requestIp + '\'' +
                '}';
    }
}
