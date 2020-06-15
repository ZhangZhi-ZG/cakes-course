package course.spring.demo4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Demo4Configuration {

    @Bean // ==> <bean id="demo4Foo" class="course.spring.demo4.Demo4FooImpl"/>
    // ===> @Component
    public Demo4Foo demo4Foo() {
        return new Demo4FooImpl();
    }
}
