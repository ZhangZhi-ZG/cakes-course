package course.patterns.chain.case4;

/**
 * @author zzhg
 * @create time 2020-07-23 10:36
 */
public class AviParseHandler extends AbstractParseHandler {
    @Override
    protected boolean preHandler(String str) {
        return str.endsWith("avi");
    }

    @Override
    protected void onHandle(String str) {
        System.out.println("AviParseHandler.onHandle");
    }
}
