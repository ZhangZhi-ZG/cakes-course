package course.patterns.chain.case4;

/**
 * @author zzhg
 * @create time 2020-07-23 10:40
 */
public class App {
    public static void main(String[] args) {
        FileParseHandlerManager.of().doHandle("xxx.avi");
    }
}
