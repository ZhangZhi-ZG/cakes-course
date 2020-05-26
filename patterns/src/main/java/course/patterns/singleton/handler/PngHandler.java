package course.patterns.singleton.handler;

public class PngHandler extends AbstractHandler {

    public PngHandler() {
        System.out.println("PngHandler.PngHandler <init>");
    }

    @Override
    protected boolean preHandle(String str) {
        return str.endsWith("png");
    }

    @Override
    protected void onHandle(String str) {
        System.out.println("png file handle" + str);
    }
}
