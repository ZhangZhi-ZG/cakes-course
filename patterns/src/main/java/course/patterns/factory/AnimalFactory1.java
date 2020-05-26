package course.patterns.factory;

public final class AnimalFactory1 {

    private AnimalFactory1() {

    }

    private static class ClassHolder {
        private static final AnimalFactory1 INSTANCE = new AnimalFactory1();
    }

    public static AnimalFactory1 of() {
        return ClassHolder.INSTANCE;
    }

    public Animal createAnimal(String desc) {
        if (desc.equals("dog")) {
            return new Dog();
        }

        if (desc.equals("cat")) {
            return new Cat();
        }

        if (desc.equals("pig")) {
            return new Pig();
        }

        throw new IllegalArgumentException("unknow desc=" + desc);
    }

}
