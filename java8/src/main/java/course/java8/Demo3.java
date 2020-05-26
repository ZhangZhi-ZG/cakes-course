package course.java8;

import java.util.Date;
import java.util.Map;

/**
 * @author zzhg
 * @date 2020-05-24
 */
public class Demo3 {
    public static void main(String[] args) {
        Foo foo = new Foo() {
            @Override
            public String foo(Integer i1, Date time, Map<String, String> mapping) {
                return null;
            }
        };

        Foo foo1 = (i1,time,mao) -> null;
        Integer i = 1;




    }

    interface Foo {
        String foo(Integer i1, Date time, Map<String, String> mapping);
    }
}
