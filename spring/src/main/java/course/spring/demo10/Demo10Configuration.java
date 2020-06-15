package course.spring.demo10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy  //开启AOP功能
public class Demo10Configuration {

    @Bean
    public DiskOperator10 diskOperator() {
        return new DiskOperator10();
    }
}
