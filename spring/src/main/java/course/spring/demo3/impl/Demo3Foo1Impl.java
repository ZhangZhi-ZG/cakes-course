package course.spring.demo3.impl;

import course.spring.demo3.Demo3Foo1;
import org.springframework.stereotype.Component;

@Component
public class Demo3Foo1Impl implements Demo3Foo1 {

    @Override
    public void foo(String msg) {
        System.out.println("Demo3Foo1Impl.foo");
    }
}
