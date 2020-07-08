package course.patterns.proxy.service.impl;

import course.patterns.proxy.service.helloService;

public class hello implements helloService {
    @Override
    public void sayHi() {
        System.out.println("Hi, Zhang Zhi");
    }
    @Override
    public void sayHello() {
        System.out.println("Hello, Zhang Zhi");
    }


}
