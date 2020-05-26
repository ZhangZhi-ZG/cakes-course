package course.patterns.builder;

public class UserApp1 {
    // public static void main(String[] args) {
    //     User user = new User();
    //     user.setName("xxx");
    //     user.setAge(23);
    //     user.setPassword("122333");
    //
    //     fooUser(user);
    // }
    //


    public static void main(String[] args) {
        User user = User.Builder.of()
                .name("")
                .age(23)
                .balance("123")
                .info("")
                .build();

        fooUser(user);

        fooUser(User.Builder.of()
                .name("")
                .age(23)
                .balance("123")
                .info("")
                .build());
    }

    private static void fooUser(User user) {

    }
}
