package course.basic.common;

/**
 * @author cbooy
 * @date 2020-05-01
 */
public class Demo2 {

  public void testWhile(boolean b) {
    int i = 0;
    while (true) {
      System.out.println("xxxx");

      if (i > 10) {
        break;
      }
    }
  }

  public void testFor() {

    for (int i = 0, j = 1024; i < 10; i++) {
      // 使用j,
      if (i == 5) {
        continue;
      }

      System.out.println(i);
    }

    String str = "";

    for (; ; ) {
      // 见到死循环，不要慌， 一定要去看 退出条件。

      if (str.equals("abc")) {
        break;
      }

      System.out.println("");
    }

    // 调用外部的接口
    int i = 0;

    for (; ; ) {
      // send http
      // response == null catch timeout exception
      i = i + 1;
      if (i > 3) {
        break;
      }
    }

  }

  public void testSwitch() {

    String str = "";

    switch (str) {
      case "A":
        System.out.println("Demo2.testSwitch,A");
        break;
      case "B":
        System.out.println("Demo2.testSwitch , B");
      default:
        System.out.println("Demo2.testSwitch, C");
    }

  }

  public void testIf() {
    /**
     * if…else if…else
     *
     */

    boolean bool = true;
    if (bool) {
      System.out.println("Demo2.main is true");
    } else {
      System.out.println("Demo2.main is false");
    }

    String str = "";

    if (str.equals("a")) {
      System.out.println("Demo2.main a");
    } else if (str.equals("b")) {
      System.out.println("Demo2.main b");
    } else if (str.equals("C")) {
      System.out.println("Demo2.main b");
    } else {
      System.out.println("Demo2.main default");
    }

    // qa关注的
    if (str.equals("a")) {
      System.out.println("Demo2.main a");
    } else if (str.equals("b")) {
      System.out.println("Demo2.main b");
    } else if (str.equals("C")) {
      System.out.println("Demo2.main b");
    }

    // .....

  }

}
