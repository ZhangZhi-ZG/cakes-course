package course.spring.demo3.impl;

import course.spring.demo3.XixiService;
import org.springframework.stereotype.Component;

@Component // ==> <bean id="XixiServiceImpl" class="course.spring.demo3.impl.XixiServiceImpl"/>
public class XixiServiceImpl implements XixiService {

    @Override
    public String sayXixi(String msg) {
        return "xixi haha <" + msg + ">";
    }
}
