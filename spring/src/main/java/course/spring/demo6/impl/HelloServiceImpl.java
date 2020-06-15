package course.spring.demo6.impl;

import course.spring.demo6.HelloService;
import course.spring.demo6.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    // @Resource // ====> <property name="hiService" ref="hiService"/>
    // private HiService hiService;

    // @Resource + @Qualifier("abc")  ======= @Resource(name = "abc") ======= @Autowired("abc")+@Qualifier("abc")
    // @Resource ===== @Autowired
    // @Resource(name = "abc") // ====> <property name="hiService" ref="hiService"/>
    // @Qualifier("abc")
    // private HiService hiService;

    @Autowired
    @Qualifier("ABC")
    private HiService hiService;

    @Override
    public String sayHello(String msg) {
        System.out.println("HelloServiceImpl.sayHi :" + msg);

        hiService.sayHi(msg);

        return "say finished.";
    }
}
