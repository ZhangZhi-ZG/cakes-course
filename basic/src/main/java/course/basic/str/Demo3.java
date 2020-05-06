package course.basic.str;

/**
 * @author cbooy
 * @date 2020-05-02
 */
public class Demo3 {

  public static void main(String[] args) {
    test1();
  }

  public static void test1() {
    String str = "hello world";
//    int length = str.length();
//    boolean equals = "".equals(str);
//    char ch = str.charAt(2);
//    boolean contains = str.contains("hello");
//    boolean startsWith = str.startsWith("h");
//    boolean endsWith = str.endsWith("d");
//    // "", 不是null
//    boolean empty = str.isEmpty();
//    boolean eq = str.equalsIgnoreCase("HELLO WORLD");

    // 字符串替换
    // res = hello java, str="hello world"
    String res = str.replaceAll("world", "java");
    System.out.println("res = " + res);
    System.out.println("str = " + str);

    // 字符串分隔
    String[] strArr = str.split(" ");

    // 字符串切割
    String substring = str.substring(1, 5);

    // 转小写
    String lowerCase = str.toLowerCase();

    String upperCase = str.toUpperCase();
  }

}
