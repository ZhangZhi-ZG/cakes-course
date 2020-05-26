package course.java8.lambda;

/**
 * 当自定义函数式接口时，用@FunctionalInterface标识一下， 确保此接口是函数式接口
 */
public class Demo3 {
    public static void main(String[] args) {
        Foo foo = new Foo() {


            @Override
            public String foo(Integer i1) {
                return null;
            }

            @Override
            public String foo1(Integer i1) {
                return null;
            }
        };

        // lambda
        // 自定义的lambda接口支持，要求必须只能有一个方法， 多个时无法确定具体实现，因此在编译器就会报错， 语法不支持
        // Foo foo1 = (i1) -> "hello";

        Foo1 foo1 = i1 -> "hello";
    }

    interface Foo {
        String foo(Integer i1);

        String foo1(Integer i1);
    }

    @FunctionalInterface
    interface Foo1 {
        String foo1(Integer i1);
    }
}
