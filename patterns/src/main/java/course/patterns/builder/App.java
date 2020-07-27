package course.patterns.builder;

/**
 * @author zzhg
 * @date 2020-06-27
 */
public class App {

    public static void main(String[] args) {
        // User2.builder().info()
        // builder1();

        builder2();

    }

    private static void builder2() {


    }


    public static void builder1() {
        User user = User.Builder.of()
                .age(12)
                .balance("1231")
                .name("zhang san")
                .build();
        System.out.println("user = " + user);
        Integer userAge = user.getAge();
        System.out.println("age = " + userAge);
    }
}
