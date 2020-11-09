package course.patterns.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler<T> implements InvocationHandler {

    private T t;

    public ProxyHandler(T t) {
        this.t = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke " + method.getName());
        Object o = method.invoke(t, args);
        System.out.println("After invoke " + method.getName());

        return o;
    }
}
