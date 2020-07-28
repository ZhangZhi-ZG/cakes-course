package course.patterns.factory.Demo1;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author zzhg
 * @create time 2020-07-28 10:35
 */
public class LocalCarFactory {
    private LocalCarFactory() {

    }

    private static class ClassHolder {
        private static final LocalCarFactory INSTANCE = new LocalCarFactory();
    }

    public static LocalCarFactory of() {
        return ClassHolder.INSTANCE;
    }

    public Optional<Car> getCar(String packName) {
        try {
            Class<?> clazz = Class.forName(packName);
            Method[] clazzMethods = clazz.getDeclaredMethods();

            // System.out.println("LocalCarFactory.getCar1");
            Arrays.stream(clazzMethods).forEach(method -> System.out.println("method name : " + method.getName()));
            return Optional.of((Car) clazz.newInstance());
        } catch (ClassNotFoundException e) {
            System.out.println("The class not found, class name "+ packName);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public Car getCar1(String packName) {
        try {
            Class<?> clazz = Class.forName(packName);

            Method[] clazzMethods = clazz.getMethods();
            System.out.println("LocalCarFactory.getCar1");
            Arrays.stream(clazzMethods).forEach(method -> System.out.println("method name : " + method.getName()));
            return (Car) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("The class not found, class name "+ packName);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }
}
