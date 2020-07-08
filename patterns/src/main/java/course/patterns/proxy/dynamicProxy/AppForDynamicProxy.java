package course.patterns.proxy.dynamicProxy;

import course.patterns.proxy.service.helloService;
import course.patterns.proxy.service.impl.hello;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class AppForDynamicProxy {

    public static void main(String[] args) {

//        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        helloService hello = new hello();

        InvocationHandler handler = new ProxyHandler(hello);


        helloService helloProxy = (helloService) Proxy.newProxyInstance(hello.getClass().getClassLoader(),hello.getClass().getInterfaces(),handler);

        helloProxy.sayHi();


    }
}
