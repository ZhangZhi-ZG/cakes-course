package course.spring.demo3.impl;

import course.spring.demo3.Demo3Foo3;
import org.springframework.stereotype.Component;

@Component
public class Demo3Foo3Impl implements Demo3Foo3 {

    @Override
    public void foo(String msg) {
        System.out.println("Demo3Foo3Impl.foo");
    }
}
