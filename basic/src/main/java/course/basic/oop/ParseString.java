package course.basic.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * 传入一个字符串，解析此字符串数字与运算符做计算
 * 比如: 字符串str="1+2", 可计算出结果=3
 */

public class ParseString {

    public Integer parsestr(String str) {
        List<Integer> n = new ArrayList<Integer>();
        String[] str_nums = {};
        Integer num;
        if (str.contains("+")) {
            str_nums = str.split("\\+");
            num = Integer.parseInt(str_nums[0]) + Integer.parseInt(str_nums[1]);

        } else if (str.contains("-")) {
            str_nums = str.split("\\-");
            num = Integer.parseInt(str_nums[0]) - Integer.parseInt(str_nums[1]);
        } else if (str.contains("*")) {
            str_nums = str.split("\\*");
            num = Integer.parseInt(str_nums[0]) * Integer.parseInt(str_nums[1]);
        } else {
            str_nums = str.split("\\/");
            num = Integer.parseInt(str_nums[0]) / Integer.parseInt(str_nums[1]);
        }


        return num;
    }

    public static void main(String[] args) {
        ParseString ps = new ParseString();
        String str = "1-2";
        Integer len = ps.parsestr(str);
        System.out.println(len);
    }
}
