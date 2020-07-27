package course.patterns.builder;

import lombok.Builder;
import lombok.Data;

//
@Builder
public class User2 {
    private String name;
    private Integer age;
    private String info;
    private String password;
    private String balance;
}
