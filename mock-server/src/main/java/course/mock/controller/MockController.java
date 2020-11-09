package course.mock.controller;

import course.mock.model.MockContext;
import course.mock.service.MockService;
import course.mock.util.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class MockController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockController.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MockService mockService;

    @RequestMapping("/**")
    public String doMock() throws FileNotFoundException {
        MockContext mockContext = MockContext.newContext()
                .setRequestUri(request.getRequestURI())
                .setRequestIp(request.getRemoteHost())
                .setRequestParams(parseRequestParam());

        LOGGER.info("mock start for uri={}", mockContext.getRequestUri());

        return mockService.doMock(mockContext);
    }

    private Map<String, String> parseRequestParam() {
        return this.request.getParameterMap()
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> ArrayUtils.getFirstValue(entry.getValue())));
    }
}
