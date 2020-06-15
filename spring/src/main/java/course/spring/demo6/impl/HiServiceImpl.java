package course.spring.demo6.impl;

import course.spring.demo6.HiService;
import org.springframework.stereotype.Component;

//起别名
@Component("ABC")
public class HiServiceImpl implements HiService {

    @Override
    public void sayHi(String msg) {
        System.out.println("HiServiceImpl.sayHi :" + msg);
    }
}
