package course.spring.demo2;

public class Hehe1ServiceImpl implements HeheService {

    @Override
    public String sayHehe(String msg) {
        return "hehe 你大娘 <" + msg + ">";
    }
}
