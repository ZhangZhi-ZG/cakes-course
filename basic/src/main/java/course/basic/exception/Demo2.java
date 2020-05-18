package course.basic.exception;

import java.io.*;

public class Demo2 {

    public static void main(String[] args) {
        // foo1();

        // foo2();

        /**
         * jdk 1.7之前
         * try{
         *
         * }catch(XxxException e){
         *
         * }finally{
         *
         * }
         *
         * jdk1.7新特性
         * try(){
         *
         * }catch(XxxException e){
         *
         * }
         *
         *
         */
    }

    public static void foo3() {
        // try() 写法必须是类要实现自 Closeable 接口
        // try (Foo2 foo = new Foo2()) {
        //
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

    static class Foo1 implements Closeable {

        @Override
        public void close() throws IOException {

        }
    }

    static class Foo2 {

    }

    public static void foo2() {
        String path = "/Users/haoc/course/code/cakes-course/basic/src/main/java/course/basic/exception/Demo2.jaa";

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("getMessage:" + e.getMessage());
            System.out.println("---------");
            e.printStackTrace();
            //  System.out.println("Demo2.FileNotFoundException");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Demo2.IOException");
        }
    }

    public static void foo1() {
        String path = "/Users/haoc/course/code/cakes-course/basic/src/main/java/course/basic/exception/Demo2.jaa";

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File(path)));

            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("getMessage:" + e.getMessage());
            System.out.println("---------");
            e.printStackTrace();
            //  System.out.println("Demo2.FileNotFoundException");
        } catch (IOException e) {
            //打印出异常堆栈信息
            e.printStackTrace();
            System.out.println("Demo2.IOException");
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
