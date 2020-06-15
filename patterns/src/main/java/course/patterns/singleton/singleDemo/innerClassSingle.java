package course.patterns.singleton.singleDemo;

/**
 * @author zzhg
 * @date 2020-05-31
 */
public class innerClassSingle {
    private innerClassSingle(){

    }

    private static class ClassLoader{
        private static final innerClassSingle INSTANCE = new innerClassSingle();
    }

    public static innerClassSingle of(){
        return ClassLoader.INSTANCE;
    }
}
