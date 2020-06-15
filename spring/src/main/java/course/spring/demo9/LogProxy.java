package course.spring.demo9;

import java.lang.reflect.Proxy;

public class LogProxy {

    public static <T> T getProxyInstance(T instance) {
        return (T) Proxy.newProxyInstance(
                instance.getClass().getClassLoader(),  // 类加载器.  基于对象->class的字节码->生成出来一个新的类-> 基于这个新的类去创建出来一个对象。这个对象就是我们说的 代理对象
                instance.getClass().getInterfaces(),   // jdk代理的典型使用，基于接口的。
                (proxy, method, args) -> {
                    try {
                        System.out.println("proxy print before log.....");
                        Object result = method.invoke(instance, args);
                        System.out.println("proxy print after log.....");
                        return result;
                    } catch (Exception e) {
                        System.out.println("proxy print error log.....");
                        return null;
                    }
                });
    }
}
