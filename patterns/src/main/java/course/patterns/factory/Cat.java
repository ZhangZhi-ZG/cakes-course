package course.patterns.factory;

public class Cat implements Animal {

    @Override
    public void run() {
        System.out.println("Cat.run");
    }

    @Override
    public void eat() {
        System.out.println("Cat.eat");
    }
}
