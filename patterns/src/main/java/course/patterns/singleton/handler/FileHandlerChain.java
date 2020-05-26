package course.patterns.singleton.handler;

public final class FileHandlerChain {

    private AbstractHandler handler;

    private FileHandlerChain() {
        this.handler = initHandlerChain();
    }

    private AbstractHandler initHandlerChain() {
        AbstractHandler pngHandler = new PngHandler();
        AbstractHandler mp4Handler = new Mp4Handler();

        pngHandler.setNextHandler(mp4Handler);

        return pngHandler;
    }

    private static class ClassHolder {
        private static final FileHandlerChain INSTANCE = new FileHandlerChain();
    }

    public static FileHandlerChain of() {
        return ClassHolder.INSTANCE;
    }

    public void handleFile(String str) {
        this.handler.doHandle(str);
    }
}
