package course.patterns.builder;

/**
 * @author zzhg
 * @date 2020-06-27
 */
public class UserDemo {

    private String name;
    private String sex;
    private Integer age;
    private String info;
    private String address;

    private UserDemo(Builder builder){
        this.name = builder.name;
        this.sex = builder.sex;
        this.age = builder.age;
        this.info = builder.info;
        this.address = builder.address;
    }


    public static class Builder{
        private String name;
        private String sex;
        private Integer age;
        private String info;
        private String address;

        public static Builder of(){

            return new Builder();
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder sex(String sex){
            this.sex = sex;
            return this;
        }

        public Builder age(Integer age){
            this.age = age;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder info(String info){
            this.info = info;
            return this;
        }


        public  UserDemo build(){
            return new UserDemo(this);
        }



    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public String getInfo() {
        return info;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "UserDemo{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", info='" + info + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
