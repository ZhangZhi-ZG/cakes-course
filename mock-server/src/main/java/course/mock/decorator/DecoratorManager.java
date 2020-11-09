package course.mock.decorator;

public enum DecoratorManager {

    newInstance;

    private IDecorator<String> packDecorator;

    DecoratorManager() {
        this.packDecorator = new RandomIdDecorator(new RandomStrDecorator(null));
    }

    public String doPack(String response) {
        return this.packDecorator.decorate(response);
    }
}
