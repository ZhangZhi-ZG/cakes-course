package course.patterns.chain.case4;

/**
 * @author zzhg
 * @create time 2020-07-23 10:36
 */
public class TxtParseHandler extends AbstractParseHandler {
    @Override
    protected boolean preHandler(String str) {
        return str.endsWith("txt");
    }

    @Override
    protected void onHandle(String str) {
        System.out.println("TxtParseHandler.onHandle");
    }
}
