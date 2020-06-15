package course.spring.demo1;

public class ServiceFactory {

    public static <T> T getService(Class<T> clazz) {
        clazz.getName();
        // 1.读取配置文件  mapping.conf
        // 2.clazz.getName() == course.spring.demo1.HelloService； 拿到药被加载接口的全类名,
        // 3.匹配配置文件内容， course.spring.demo1.HelloService = course.spring.demo1.HelloServiceImpl
        // ======> 2的course.spring.demo1.HelloService  与 3的course.spring.demo1.HelloService  等等
        // 4.可以拿到course.spring.demo1.HelloServiceImpl
        // 5.实例化 4所得的具体类，然后 return
        //  =====  Class<?> newClazz = Class.forName("course.spring.demo1.HelloServiceImpl")
        //  =====      newClazz.newInstance();

        return null;
        //  return new HelloServiceImpl();
    }
}
