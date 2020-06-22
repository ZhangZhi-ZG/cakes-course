package course.boot.examples.component;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器:  拦截请求处理一些通用的逻辑，比如登陆。
 * author: xiha
 * crate time: 2020/6/21
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * 前置处理
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("LoginInterceptor ------- preHandle");

        // examples/xxxx/xxx
        // String requestURI = request.getRequestURI();
        String token = request.getHeader("token");
        LOGGER.info("login token = {}", token);

        // token  请求公司的 passport, 去换信息，看一下 这个 token是否在系统中，在呢， 就是登陆，不在呢， 就是没登录， 给你跳转到登录页
        if (Strings.isNullOrEmpty(token)) {
            return false;
        }

        return true;
    }

    /**
     * 后置处理
     * <p>
     * idNo: 1101111111123434234234   身份证号  =>   110*************234
     * <p>
     * //
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOGGER.info("LoginInterceptor ------- postHandle");
    }

    /**
     * 处理完成
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOGGER.info("LoginInterceptor ------- afterCompletion");
    }
}
