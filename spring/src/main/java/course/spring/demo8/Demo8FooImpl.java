package course.spring.demo8;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Demo8FooImpl implements Demo8Foo {

    public Demo8FooImpl() {
        System.out.println("Demo8FooImpl.Demo8FooImpl.... init");
    }

    @Override
    public void test() {
        System.out.println("Demo8FooImpl.test");
    }
}
