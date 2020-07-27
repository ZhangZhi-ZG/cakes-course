package course.patterns.chain.case3;

/**
 * @author zzhg
 * @create time 2020-07-22 16:40
 */
public class Mp4VedioHandler extends AbstractParseHandler<MyVedio> {
    @Override
    public boolean preHandle(MyVedio myVedio) {
        return myVedio.getVedioType().equals(VedioType.MP4.toString());
    }

    @Override
    public void onHandle(MyVedio myVedio) {
        System.out.println("Mp4VedioHandler.onHandle");
    }
}
