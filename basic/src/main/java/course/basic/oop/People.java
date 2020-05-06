package course.basic.oop;

/**
 * @author cbooy
 * @date 2020-05-01
 */
public  class People {

  // 常量（final修饰过的变量）--不可以被修改，而且必须被初始化
  public static final int III = 0;

  private String name;

  private int age;

  private static String info;

  public final void foo1() {
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
