package course.basic.str.StringUtilsDemo;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * @author zzhg
 * @create time 2020-07-29 10:01
 */
public class StringUtilsApp {
    public static void main(String[] args) {


        String str = new String("StringUtilsTest");

        System.out.println("str = " + str);

        String ss = StringUtils.replace("StringUtilsTest", "Test", "Demo");

        System.out.println("ss = " + ss);
        // boolean b = StringUtils.contains(str, "String");
        // System.out.println("b = " + b);
    }

    @Test
    public  void foo1() {
        String s = StringUtils.abbreviate("hello World", 7);
        System.out.println("s = " + s);
    }
}
