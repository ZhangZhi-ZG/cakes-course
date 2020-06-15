package course.spring.demo5.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@ComponentScan(basePackages = "course.spring.demo5.impl")
// @ComponentScan // 表示会扫描当前类所在包下所有@Component
public class Demo5Configuration {

    @Bean
    public LocalDateTime getCurrentDate() {
        return LocalDateTime.now().plusDays(1);
    }
}
