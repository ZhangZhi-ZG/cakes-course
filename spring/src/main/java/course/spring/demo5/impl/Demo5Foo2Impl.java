package course.spring.demo5.impl;

import course.spring.demo5.Demo5Foo2;
import org.springframework.stereotype.Component;

@Component
public class Demo5Foo2Impl implements Demo5Foo2 {

    @Override
    public String foo(String msg) {
        return "demo5 foo 2";
    }
}
