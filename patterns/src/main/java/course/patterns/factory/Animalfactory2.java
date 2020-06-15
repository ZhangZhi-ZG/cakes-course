package course.patterns.factory;

import java.util.Optional;

public final class Animalfactory2 {
    private Animalfactory2() {

    }

    private static class ClassHolder {
        private static final Animalfactory2 INSTANCE = new Animalfactory2();
    }

    public static Animalfactory2 of() {
        return ClassHolder.INSTANCE;
    }

    // TODO String pkgName 可以放到本地的配置文件里
    public Optional<Animal> createAnimal(String pkgName) {
        try {
            Class<?> clazz = Class.forName(pkgName);

            return Optional.of((Animal) clazz.newInstance());
        } catch (ClassNotFoundException e) {
            System.out.println("不存在的类");
        } catch (IllegalAccessException e) {
            System.out.println("异常访问，可能此类没有对构造器的访问权限");
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

}
