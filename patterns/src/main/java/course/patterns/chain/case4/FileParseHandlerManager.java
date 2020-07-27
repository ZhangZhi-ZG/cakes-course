package course.patterns.chain.case4;

/**
 * @author zzhg
 * @create time 2020-07-23 10:33
 */
public final class FileParseHandlerManager {

    private AbstractParseHandler fileParseHandler;

    private FileParseHandlerManager () {
        this.fileParseHandler = initFileParseHandlerChain();
    }

    private AbstractParseHandler initFileParseHandlerChain() {
        TxtParseHandler txtParseHandler = new TxtParseHandler();
        AviParseHandler aviParseHandler = new AviParseHandler();
        Mp4ParseHandler mp4ParseHandler = new Mp4ParseHandler();

        txtParseHandler.addNextParseHandler(aviParseHandler);
        aviParseHandler.addNextParseHandler(mp4ParseHandler);

        return txtParseHandler;

    }

    private static class ClassHolder {
        private static final FileParseHandlerManager INSTANCE = new FileParseHandlerManager();
    }

    public static FileParseHandlerManager of() {
        return ClassHolder.INSTANCE;
    }


    public void doHandle(String str){
        this.fileParseHandler.doHandle(str);
    }




}
