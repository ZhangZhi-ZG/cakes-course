package course.spring.demo12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Demo12ServiceImpl {

    @Autowired
    private User user;

    public void test() {
        System.out.println("Demo12ServiceImpl.test");

        System.out.println("Demo12ServiceImpl.user name: " + user.getName() + ", age=" + user.getAge());
    }

}