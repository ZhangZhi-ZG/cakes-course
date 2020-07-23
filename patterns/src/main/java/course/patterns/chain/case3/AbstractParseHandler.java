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

    public abstract boolean prehandle(T t);

    public abstract void onHandle(T t);

    public void doHandle(T t) {

        if (prehandle(t)) {
            onHandle(t);
        }
        System.out.println("this.nextParseHandler = " + this.nextParseHandler);
        if (this.nextParseHandler != null) {
            this.nextParseHandler.doHandle(t);
        }

    }


}
