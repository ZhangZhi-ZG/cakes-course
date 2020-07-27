package course.patterns.chain.case3;

/**
 * @author zzhg
 * @create time 2020-07-22 16:31
 */
public abstract class AbstractParseHandler<T> {

    private AbstractParseHandler<T> nextParseHandler;

    public void addNextHandler(AbstractParseHandler<T> nextParseHandler){
        this.nextParseHandler = nextParseHandler;
    }

    protected abstract boolean preHandle(T t);

    protected abstract void onHandle(T t);

    protected void doHandle(T t) {

        if (preHandle(t)) {
            onHandle(t);
        }
        System.out.println("this.nextParseHandler = " + this.nextParseHandler);
        if (this.nextParseHandler != null) {
            this.nextParseHandler.doHandle(t);
        }

    }


}
