package course.spring.demo3.impl;

import course.spring.demo3.Demo3Foo2;
import org.springframework.stereotype.Component;

@Component
public class Demo3Foo2Impl implements Demo3Foo2 {

    @Override
    public void foo(String msg) {
        System.out.println("Demo2Foo1Impl.foo");
    }
}
