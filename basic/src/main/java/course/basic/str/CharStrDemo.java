package course.basic.str;

/**
 * @author haoc
 */
public class CharStrDemo {

  public static void main(String[] args) {
    String str = "hello world";

    char[] chs = str.toCharArray();
    for (char ch : chs) {
      System.out.println(ch);
    }

    String newStr = new String(chs);
    System.out.println("newStr = " + newStr);
  }

}
