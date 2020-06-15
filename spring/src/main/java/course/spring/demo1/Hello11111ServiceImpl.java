package course.spring.demo1;

public class Hello11111ServiceImpl implements HelloService {

    private String foo;

    private String foo1;

    private String foo2;

    private String foo3;

    private String foo4;

    private HeheService heheService;

    public Hello11111ServiceImpl() {
    }

    public Hello11111ServiceImpl(String foo) {
        this.foo = foo;
    }

    @Override
    public String sayHi(String msg) {
        return "hiiiiiiiiiii <" + msg + ">";
    }
}
