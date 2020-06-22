package course.boot.examples.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Servlet
 * author: xiha
 * crate time: 2020/6/21
 */
// @WebServlet(name = "basicServlet")
public class BasicServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        Map<String, String> parameterMap = handleParamMap(req.getParameterMap());
        LOGGER.info("basic servlet start for uri={}, params={}", requestURI, parameterMap);
        if (requestURI.equals("/examples/ping1111")) {
            resp.setStatus(200);
            ServletOutputStream outputStream = resp.getOutputStream();
            outputStream.write("hahahahah".getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }

    private Map<String, String> handleParamMap(Map<String, String[]> parameterMap) {
        return parameterMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, param -> param.getValue()[0]));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
