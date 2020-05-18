package course.basic.exception;

import java.io.Closeable;
import java.io.IOException;

/**
 * 演示而用，看下 try() catch的真实面目
 */
public class Demo3 {
    public static void main(String[] args) {
        try (Foo1 foo = new Foo1()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Foo1 implements Closeable {

        @Override
        public void close() throws IOException {

        }
    }
}
