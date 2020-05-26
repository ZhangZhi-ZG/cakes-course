package course.patterns.singleton.handler;

public class Mp4Handler extends AbstractHandler {
    public Mp4Handler() {
        System.out.println("Mp4Handler.Mp4Handler <init>");
    }

    @Override
    protected boolean preHandle(String str) {
        return str.endsWith("mp4");
    }

    @Override
    protected void onHandle(String str) {
        System.out.println("mp4 file handle" + str);
    }
}
