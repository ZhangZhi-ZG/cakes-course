package course.mock.controller;

import cn.hutool.core.io.IoUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;

//@RestController
public class MockController0 {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockController0.class);

    private static final String MOCK_DATA_ROOT_PATH = "xxxx"; // 这个地址是你自己机器上的地址

    @Autowired
    private HttpServletRequest request;

//    @RequestMapping("/**") 这是第一版的写法，为了方便大家后续的查看
    public String doMock() throws FileNotFoundException {
        LOGGER.info("request uri = {}", request.getRequestURI());

        String requestURI = request.getRequestURI();

        String var1 = StringUtils.substringAfter(requestURI, "/");

        // ghjkljh_ghkgfyuiower_sfwefrer
        String var2 = StringUtils.replace(var1, "/", "_");

        return IoUtil.read(new FileInputStream(new File(MOCK_DATA_ROOT_PATH + var2)), Charset.defaultCharset());
    }
}
