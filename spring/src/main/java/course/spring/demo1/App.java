package course.spring.demo1;

public class App {

    public static void main(String[] args) {
        // 1.直接使用
        // HelloService helloService = new HelloServiceImpl();

        // 2.将实现与用户分离，工厂方法区构造
        HelloService helloService = ServiceFactory.getService(HelloService.class);

        String msg = helloService.sayHi("spring");
        System.out.println("msg = " + msg);
    }
}
