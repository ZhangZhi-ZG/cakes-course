package course.spring.demo4;

public class Demo4FooImpl implements Demo4Foo {

    @Override
    public String foo(String info) {
        System.out.println("Demo4FooImpl.foo");
        return "demo4 foo";
    }
}
