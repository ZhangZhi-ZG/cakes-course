package course.patterns.chain.case4;

/**
 * @author zzhg
 * @create time 2020-07-23 10:29
 */
public abstract class AbstractParseHandler {

    private AbstractParseHandler nextParseHandler;

    public void addNextParseHandler(AbstractParseHandler nextParseHandler) {
        this.nextParseHandler = nextParseHandler;
    }

    protected abstract boolean preHandler(String str);

    protected abstract void onHandle(String str);

    public void doHandle(String str) {
        if (preHandler(str)) {
            onHandle(str);
        }

        if (this.nextParseHandler != null) {
            this.nextParseHandler.doHandle(str);
        }
    }

}
