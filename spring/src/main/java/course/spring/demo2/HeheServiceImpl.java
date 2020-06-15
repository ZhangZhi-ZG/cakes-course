package course.spring.demo2;

public class HeheServiceImpl implements HeheService {

    private String name;

    private Foo1Service foo1Service;

    @Override
    public String sayHehe(String msg) {
        return "name = " + this.name + ",hehe 你大爷 <" + msg + ">";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Foo1Service getFoo1Service() {
        return foo1Service;
    }

    public void setFoo1Service(Foo1Service foo1Service) {
        this.foo1Service = foo1Service;
    }
}
