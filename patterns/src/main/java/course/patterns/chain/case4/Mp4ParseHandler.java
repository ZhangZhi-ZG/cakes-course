package course.patterns.chain.case4;

/**
 * @author zzhg
 * @create time 2020-07-23 10:36
 */
public class Mp4ParseHandler extends AbstractParseHandler {
    @Override
    protected boolean preHandler(String str) {
        return str.endsWith("mp4");
    }

    @Override
    protected void onHandle(String str) {
        System.out.println("Mp4ParseHandler.onHandle");
    }
}
