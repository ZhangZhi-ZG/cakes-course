package course.basic.oop;

/**
 * @author cbooy
 * @date 2020-05-01
 */
public class People {

  // 敞亮
  public static final int III = 0;

  private String name;

  private int age;

  private static String info;

  public void foo1() {
    System.out.println("People.foo1");
    foo3();
  }

  public static void foo2() {
    System.out.println("People.foo2");
  }

  public void foo4() {
    foo3();
  }

  private void foo3() {

  }

}
