package course.basic.str;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.apache.commons.lang3.StringUtils;

/**
 * @author cbooy
 * @date 2020-05-02
 */
public class Demo4 {

  public static void main(String[] args) {
    // 主要是介绍StringUtils工具类，强烈建议大家，去把此类的所有方法看一遍，了解其能力， 并适当的去看看每个方法的源码实现
    int i = 1 << 2;
    System.out.println("i = " + i);
    boolean empty = StringUtils.isEmpty("12321");
    String substring = StringUtils.substring("hello world", 1, 3);
    String s = new String("zhangsan");
    int index = s.indexOf("zh");
    boolean contains = StringUtils.contains("heall", "h");
    int compare = StringUtils.compare("zhangsan", "lisi");
    String reverse = StringUtils.reverse("11b11");
    System.out.println("reverse = " + reverse);
    System.out.println("compare = " + compare);
//    StringUtils.
    String name = "zhang san";
    boolean equals = "zhan".equals(name);
    System.out.println("equals = " + equals);
    System.out.println("empty = " + empty);

  }
}
