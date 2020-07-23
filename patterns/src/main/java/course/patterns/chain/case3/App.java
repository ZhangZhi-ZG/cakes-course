package course.patterns.chain.case3;

/**
 * @author zzhg
 * @create time 2020-07-22 16:22
 */
public class App {
    public static void main(String[] args) {
        MyVedio vedio = MyVedio.builder()
                .vedioName("xxx.avi")
                .vedioPath("/root/mv")
                .vedioType("AVI")
                .build();

        VedioHandlerManager.of().doParse(vedio);
    }
}
