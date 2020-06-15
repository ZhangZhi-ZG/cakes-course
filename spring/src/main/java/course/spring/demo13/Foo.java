package course.spring.demo13;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zzhg
 * @date 2020-06-12
 */
public class Foo {

    private UserDemo13 userDemo13;

    private Map<String,Integer> map;

    private List<String> list;

    private Date date;

    private String name;

    private Integer age;

    public UserDemo13 getUserDemo13() {
        return userDemo13;
    }

    public void setUserDemo13(UserDemo13 userDemo13) {
        this.userDemo13 = userDemo13;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Foo{" +
                "userDemo13=" + userDemo13 +
                ", map=" + map +
                ", list=" + list +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
