package course.patterns.singleton.handler;

public class App {
    public static void main(String[] args) {
        FileHandlerChain.of().handleFile("xxoo.png");
        FileHandlerChain.of().handleFile("xxoo.mp4");
        FileHandlerChain.of().handleFile("xxoo.png");
        FileHandlerChain.of().handleFile("xxoo.png");
        FileHandlerChain.of().handleFile("xxoo.mp4");
        FileHandlerChain.of().handleFile("xxoo.png");
        FileHandlerChain.of().handleFile("xxoo.mp4");
        FileHandlerChain.of().handleFile("xxoo.png");
    }
}
