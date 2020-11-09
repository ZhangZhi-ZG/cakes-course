package course.mock.decorator;

import java.util.Objects;

public abstract class BasePackResponseDecorator implements IDecorator<String> {

    private BasePackResponseDecorator innerDecorator;

    public BasePackResponseDecorator(BasePackResponseDecorator innerDecorator) {
        this.innerDecorator = innerDecorator;
    }

    protected abstract String onDecorate(String data);

    @Override
    public String decorate(String data) {
        if (!Objects.isNull(this.innerDecorator)) {
            String result = this.innerDecorator.decorate(data);
            return onDecorate(result);
        }

        return onDecorate(data);
    }
}
