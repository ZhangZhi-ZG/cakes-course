package course.patterns.chain.case2;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public abstract class AbstractHandler<T> {
    private AbstractHandler<T> nextHandler;

    public void addNextHandler(AbstractHandler<T> nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract boolean preHandle(T t);

    protected abstract void onHandle(T t);

    public void doHandle(T t) {
        if (preHandle(t)) {
            onHandle(t);
            return;
        }

        if (this.nextHandler != null) {
            this.nextHandler.doHandle(t);
        }
    }
}
