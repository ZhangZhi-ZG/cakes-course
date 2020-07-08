package course.patterns.decorator;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public abstract class AbstractDecorator implements IDecorator {

    private AbstractDecorator decorator;

    public AbstractDecorator(AbstractDecorator decorator) {
        this.decorator = decorator;
    }

    protected abstract String onDecorate(String str);

    @Override
    public String decorate(String str) {
        if (this.decorator != null) {
            str = this.decorator.decorate(str);
        }
        return onDecorate(str);
    }
}
