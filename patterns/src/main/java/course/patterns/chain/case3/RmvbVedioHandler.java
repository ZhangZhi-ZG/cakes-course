package course.patterns.chain.case3;

/**
 * @author zzhg
 * @create time 2020-07-22 16:40
 */
public class RmvbVedioHandler extends AbstractParseHandler<MyVedio> {
    @Override
    public boolean prehandle(MyVedio myVedio) {
        return myVedio.getVedioType().equals(VedioType.RMVB.toString());
    }

    @Override
    public void onHandle(MyVedio myVedio) {

        System.out.println("RmvbVedioHandler.onHandle");
    }
}
