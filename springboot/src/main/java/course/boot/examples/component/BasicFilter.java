package course.boot.examples.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 过滤器
 * author: xiha
 * crate time: 2020/6/21
 */
public class BasicFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        LOGGER.info("BasicFilter start. uri={}", httpServletRequest.getRequestURI());

        // 过滤器是需要去构造成一个链的，因此一个过滤器处理完成之后，需要去调下一个过滤器，因此这行代码 很重要
        chain.doFilter(request, response);
    }
}
