package course.patterns.singleton.handler;

public abstract class AbstractHandler {

    private AbstractHandler nextHandler;

    protected abstract boolean preHandle(String str);

    protected abstract void onHandle(String str);

    public void doHandle(String str) {
        // 是否是当前处理器
        if (preHandle(str)) {
            onHandle(str);
            return;
        }

        // 如果不是，且下一个
        if (null != this.nextHandler) {
            this.nextHandler.doHandle(str);
        }
    }

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
