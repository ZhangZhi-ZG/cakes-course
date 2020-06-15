package course.spring.demo6.impl;

import course.spring.demo6.HiService;
import org.springframework.stereotype.Component;

@Component
public class HiiiiiiServiceImpl implements HiService {

    @Override
    public void sayHi(String msg) {
        System.out.println("HiiiiiiServiceImpl.sayHi");
    }
}
