package course.patterns.factory;

public class Pig implements Animal {

    @Override
    public void run() {
        System.out.println("Pig.run");
    }

    @Override
    public void eat() {
        System.out.println("Pig.eat");
    }
}
