package course.patterns.chain.case3;

/**
 * @author zzhg
 * @create time 2020-07-22 16:36
 */
public final class VedioHandlerManager {
    private AbstractParseHandler<MyVedio> vedioParseHandler;

    private VedioHandlerManager() {
        this.vedioParseHandler = initVedioHandlerChain();
    }

    private AbstractParseHandler<MyVedio> initVedioHandlerChain() {
        Mp4VedioHandler mp4VedioHandler = new Mp4VedioHandler();
        AviVedioHandler aviVedioHandler = new AviVedioHandler();
        RmvbVedioHandler rmvbVedioHandler = new RmvbVedioHandler();

        mp4VedioHandler.addNextHandler(aviVedioHandler);
        aviVedioHandler.addNextHandler(rmvbVedioHandler);

        return mp4VedioHandler;

    }

    private static class ClassHolder {
        private static final VedioHandlerManager INSTANCE = new VedioHandlerManager();
    }

    public static VedioHandlerManager of() {
        return ClassHolder.INSTANCE;
    }

    public void doParse(MyVedio myVedio) {
        this.vedioParseHandler.doHandle(myVedio);
    }



}
