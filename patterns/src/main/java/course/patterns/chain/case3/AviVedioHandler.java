package course.patterns.chain.case3;

/**
 * @author zzhg
 * @create time 2020-07-22 16:40
 */
public class AviVedioHandler extends AbstractParseHandler<MyVedio> {
    @Override
    public boolean preHandle(MyVedio myVedio) {
        return myVedio.getVedioType().equals(VedioType.AVI.toString());
    }

    @Override
    public void onHandle(MyVedio myVedio) {

        System.out.println("AviVedioHandler.onHandle");
    }
}
