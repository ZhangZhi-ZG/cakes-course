package course.patterns.builder;

/**
 * @author zzhg
 * @date 2020-06-27
 */
public class UserDemoApp {
    public static void main(String[] args) {
        UserDemo userDemo = UserDemo.Builder.of()
                .address("pingguoyuan")
                .age(23).info("work")
                .sex("male")
                .build();

        String name = userDemo.getName();
        System.out.println("userDemo = " + userDemo);
    }
}
