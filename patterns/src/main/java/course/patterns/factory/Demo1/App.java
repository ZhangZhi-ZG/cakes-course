package course.patterns.factory.Demo1;


import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author zzhg
 * @create time 2020-07-28 10:25
 */
public class App {
    private static Car car;
    public static void main(String[] args) {
        // foo1();

        // foo2("Audi");






        // App.car.band();
    }


    @Test
    public void testOptional() {
        Optional<Car> option = LocalCarFactory.of().getCar("course.patterns.factory.Demo1.BWM");
        if (option.isPresent()) {
            option.get().band();
            option.get().run();
        }
    }
    private static void foo1() {
        Audi audi = new Audi();

        audi.band();
    }


    public static void foo2(String bandName) {


        if ("Audi".equals(bandName)) {
            car = new Audi();
        }

        if ("BWM".equals(bandName)) {
            car = new BWM();

        }

        car.band();
        car.run();
    }
}
