package course.spring.demo2;

/**
 * @author zzhg
 * @date 2020-06-07
 */
public class HahaServiceImpl implements HahaService {
    @Override
    public String setName(String name) {
        return "Hha name" + name + ".";
    }
}
