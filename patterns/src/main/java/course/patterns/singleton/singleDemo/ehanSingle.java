package course.patterns.singleton.singleDemo;



/**
 * @author zzhg
 * @date 2020-05-29
 */
public class ehanSingle {

    private ehanSingle() {
    }

    private static final ehanSingle INSTANCE = new ehanSingle();

    public static ehanSingle getInstance(){
        System.out.println("instance = " + INSTANCE);
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            ehanSingle.getInstance();

        }

    }
}
