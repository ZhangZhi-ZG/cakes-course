package course.patterns.builder;

public class User {

    private String name;
    private Integer age;
    private String info;
    private String password;
    private String balance;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.info = builder.info;
        this.password = builder.password;
        this.balance = builder.balance;
    }

    public static class Builder {
        private String name;
        private Integer age;
        private String info;
        private String password;
        private String balance;

        public static Builder of() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder info(String info) {
            this.info = info;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder balance(String balance) {
            this.balance = balance;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String getName() {
        return name;
    }

<<<<<<< HEAD
=======


>>>>>>> a7997e3359f619d7d7409cb5b3c0327378de9998
    public Integer getAge() {
        return age;
    }

<<<<<<< HEAD
=======


>>>>>>> a7997e3359f619d7d7409cb5b3c0327378de9998
    public String getInfo() {
        return info;
    }

<<<<<<< HEAD
=======


>>>>>>> a7997e3359f619d7d7409cb5b3c0327378de9998
    public String getPassword() {
        return password;
    }

<<<<<<< HEAD
=======


>>>>>>> a7997e3359f619d7d7409cb5b3c0327378de9998
    public String getBalance() {
        return balance;
    }

<<<<<<< HEAD
=======

>>>>>>> a7997e3359f619d7d7409cb5b3c0327378de9998
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", info='" + info + '\'' +
                ", password='" + password + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
