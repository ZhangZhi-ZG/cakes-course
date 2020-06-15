package course.spring.demo13.Impl;

import course.spring.demo13.Car;
import org.springframework.stereotype.Component;

/**
 * @author zzhg
 * @date 2020-06-09
 */
@Component
public class BWM implements Car {
    @Override
    public void run(String msg) {
        System.out.println("BWM.run: " + msg);
    }

    @Override
    public void band(String band) {
        System.out.println("当前汽车的牌子是"+band);
    }

    @Override
    public void mile(Integer mile) {
        System.out.println("已经跑了"+mile+"公里");
    }
}
