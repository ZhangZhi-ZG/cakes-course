package course.patterns.factory;

public class Dog implements Animal {
    @Override
    public void run() {
        System.out.println("Dog.run");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat");
    }
}
