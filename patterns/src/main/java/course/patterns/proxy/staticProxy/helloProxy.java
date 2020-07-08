package course.patterns.proxy.staticProxy;

import course.patterns.proxy.service.impl.hello;
import course.patterns.proxy.service.helloService;

/**
 * 静态代理：
 *      1、创建一个代理类实现目标接口
 *      2、内部调用该接口的某一个实现类
 * 缺点：
 *      静态代理如果需要代理多个类的话，需要创建多个代理类，比较繁琐
 */
public class helloProxy implements helloService {

    private helloService hello = new hello();

    @Override
    public void sayHello() {
        System.out.println("sys hello before.");
        hello.sayHello();;
        System.out.println("say hello after..");
    }

    @Override
    public void sayHi() {
        System.out.println("sys hi before.");
        hello.sayHello();;
        System.out.println("say hi after..");
    }
}
