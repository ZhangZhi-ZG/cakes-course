package course.mock.chain;

import java.util.Objects;

public abstract class AbstractHandler<T, R> {
    private AbstractHandler<T, R> nextHandler;

    protected abstract boolean preHandle(T context);

    protected abstract R onHandle(T context) throws Exception;

    public R doHandle(T context) {
        if (Objects.isNull(context)) {
            throw new IllegalArgumentException("context should not be null.");
        }

        if (preHandle(context)) {
            try {
                return onHandle(context);
            } catch (Exception e) {
                throw new IllegalStateException("on handle failed.", e);
            }
        }

        if (!Objects.isNull(this.nextHandler)) {
            return this.nextHandler.doHandle(context);
        }

        throw new IllegalStateException("un know next handler.");
    }

    public void setNextHandler(AbstractHandler<T, R> nextHandler) {
        this.nextHandler = nextHandler;
    }
}
