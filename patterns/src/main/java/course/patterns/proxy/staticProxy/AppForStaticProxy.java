package course.patterns.proxy.staticProxy;

public class AppForStaticProxy {

    public static void main(String[] args) {
        helloProxy helloProxy = new helloProxy();
        helloProxy.sayHi();
    }
}
