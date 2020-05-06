package course.basic.str;

/**
 * @author cbooy
 * @date 2020-05-02
 */
public class Demo1 {

  public static void main(String[] args) {
    test1();
  }

  public static void test1() {
    // 最常用
    String str = "hello world";
    System.out.println(str);

    // 只在特定场景下
    byte[] buf = new byte[128];
    String str2 = new String(buf, 0, 128);
    String str3 = new String("hello world");
    System.out.println("str2 = " + str2);
    System.out.println("str3 = " + str3);
  }

}
