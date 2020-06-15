package course.spring.demo1;

public class App1 {

    // http
    public static void main(String[] args) {

        // 1.直接使用
        HelloService helloService = new Hello11111ServiceImpl();
        String msg = helloService.sayHi("spring");
        System.out.println("msg = " + msg);
    }
}
