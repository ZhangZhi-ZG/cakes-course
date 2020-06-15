package course.spring.demo8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Demo8Conf.class);

        // Demo8Foo foo1 = context.getBean(Demo8Foo.class);
        // Demo8Foo foo2 = context.getBean(Demo8Foo.class);
        // Demo8Foo foo3 = context.getBean(Demo8Foo.class);
        // Demo8Foo foo4 = context.getBean(Demo8Foo.class);
        //
        // System.out.println("foo1 = " + foo1);
        // System.out.println("foo2 = " + foo2);
        // System.out.println("foo3 = " + foo3);
        // System.out.println("foo4 = " + foo4);

        // foo.test();

        // 单例并不是全进程级别的单例，是相对于容器的单例， 若新建多个容器，自然就存在多个实例
        // System.out.println("App.main-----------");
        //
        // ApplicationContext context1 = new AnnotationConfigApplicationContext(Demo8Conf.class);
        //
        // Demo8Foo foo11 = context1.getBean(Demo8Foo.class);
        // Demo8Foo foo21 = context1.getBean(Demo8Foo.class);
        // Demo8Foo foo31 = context1.getBean(Demo8Foo.class);
        // Demo8Foo foo41 = context1.getBean(Demo8Foo.class);
        //
        // System.out.println("foo1 = " + foo11);
        // System.out.println("foo2 = " + foo21);
        // System.out.println("foo3 = " + foo31);
        // System.out.println("foo4 = " + foo41);
    }
}
