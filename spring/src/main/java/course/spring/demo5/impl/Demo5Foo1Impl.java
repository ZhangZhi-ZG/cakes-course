package course.spring.demo5.impl;

import course.spring.demo5.Demo5Foo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Demo5Foo1Impl implements Demo5Foo1 {

    //依赖注入
    @Autowired
    private LocalDateTime plusOneDay;

    @Override
    public String foo(String msg) {
        System.out.println("plusOneDay = " + plusOneDay);
        return "demo 5 foo1";
    }
}
