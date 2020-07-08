package course.patterns.decorator;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public final class DecoratorManager {

    private IDecorator decorator;

    private DecoratorManager() {
        this.decorator = new RandomStrDecorator(new RandomIdDecorator(null));
    }

    private static final class ClassHolder {
        private static final DecoratorManager INSTANCE = new DecoratorManager();
    }

    public static DecoratorManager of() {
        return ClassHolder.INSTANCE;
    }

    public String doDecorate(String str) {
        return this.decorator.decorate(str);
    }

}
