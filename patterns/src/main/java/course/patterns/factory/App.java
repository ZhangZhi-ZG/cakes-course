package course.patterns.factory;

import java.util.Optional;

public class App {
    public static void main(String[] args) {
        // foo1("dog");
        // foo1("cat");
        // foo1("pig");

        // foo2();

        foo3("course.patterns.factory.Cat");
        foo3("course.patterns.factory.Dog");
        foo3("course.patterns.factory.Pig");
    }

    // 这个与具体实现无关
    private static void foo1(String desc) {
        Animal animal = AnimalFactory1.of().createAnimal(desc);
        animal.run();
        animal.eat();
    }

    // 这种方式跟我的 具体实现类 耦合在一起了
    private static void foo2() {
        Animal animal = new Dog();
        animal.run();
        animal.eat();
    }

    private static void foo3(String pkgName) {
        Optional<Animal> optional = Animalfactory2.of().createAnimal(pkgName);
        if (optional.isPresent()) {
            optional.get().run();
            optional.get().eat();
        }
    }
}
