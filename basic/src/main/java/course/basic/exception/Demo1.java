package course.basic.exception;

import java.io.IOException;

public class Demo1 {

    public static void main(String[] args){
        //RuntimeException可以被抛出，但是不一定需要处理
        testRuntimeException();

        //受检异常必须被捕获并处理
//        foo();
        try {
            foo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //受检异常-IOException
    public static void foo() throws IOException {
        testCheckedException();
    }

    //RuntimeException-NullPointerException
    public static void testRuntimeException() throws NullPointerException {
        System.out.println("Demo1.testRuntimeException");
    }

    public static void testCheckedException() throws IOException {
        System.out.println("Demo1.testCheckedException");
    }
}
