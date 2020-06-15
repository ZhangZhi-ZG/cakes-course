package course.spring.demo6;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//默认搜索当前目录下所有被component修饰的类，可以指定包路径---basePackages = "course.spring.demo5"
@ComponentScan()
public class Demo6Configuration {

}
