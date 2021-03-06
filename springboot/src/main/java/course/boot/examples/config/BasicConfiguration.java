package course.boot.examples.config;

import course.boot.examples.component.BasicFilter;
import course.boot.examples.component.LoginInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
@Configuration // ==> beans.xml
@ServletComponentScan(basePackages = "course.boot.examples.component")
// @EnableScheduling  //开启定时任务
public class BasicConfiguration implements WebMvcConfigurer {

    //添加过滤器
    @Bean
    public FilterRegistrationBean<BasicFilter> basicFilter() {
        return new FilterRegistrationBean<>(new BasicFilter());
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/pay/*");
    }
}
