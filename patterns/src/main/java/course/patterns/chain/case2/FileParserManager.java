package course.patterns.chain.case2;

import course.patterns.bean.MyFile;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public final class FileParserManager {
    private final AbstractHandler<MyFile> fileParserHandler;

    private FileParserManager() {
        this.fileParserHandler = initParserHandlerChain();
    }

    private AbstractHandler<MyFile> initParserHandlerChain() {

        AbstractHandler<MyFile> mp4ParserHandler = new Mp4ParserHandler();
        AbstractHandler<MyFile> aviParserHandler = new AviParserHandler();
        AbstractHandler<MyFile> rmvbParserHandler = new RmvbParserHandler();
        AbstractHandler<MyFile> pngParserHandler = new PngParserHandler();

        mp4ParserHandler.addNextHandler(aviParserHandler);
        aviParserHandler.addNextHandler(rmvbParserHandler);
        rmvbParserHandler.addNextHandler(pngParserHandler);

        return mp4ParserHandler;
    }

    private static final class ClassHolder {
        private static final FileParserManager INSTANCE = new FileParserManager();
    }

    public static FileParserManager of() {
        return ClassHolder.INSTANCE;
    }

    public void doParse(MyFile myFile) {
        this.fileParserHandler.doHandle(myFile);
    }
}
