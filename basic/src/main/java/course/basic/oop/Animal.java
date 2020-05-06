package course.basic.oop;

import org.apache.commons.lang3.StringUtils;

/**
 * @author cbooy
 * @date 2020-05-01
 */
public class Animal {

  // 属性 & 字段
  String name = "cat";
  String sex = "male";

  void foo1() {

  }

  int foo2() {
    return -1;
  }

  int foo3(int i1) {
    return i1 + 1024;
  }

  /**
   * 函数的重载：
   * 1、函数名称一样
   * 2、参数类型或者个数不同
   * 3、如果参数相同，返回值类型不同，不能以相同的函数名进行命名。
   *
   */
  int foo3(int i1, String str) {
    return i1 + 1024;
  }

  void foo4(int i1, String... strs) {
    String[] ss = strs;
    for (String s : ss) {
      System.out.println("s = " + s);
    }
  }

  void foo5() {
    foo4(1, "a");
    foo4(1, "a", "b");
    foo4(1, "a", "b", "c");
  }

  //如果不对类进行实例化调用，静态方法不可以调用非静态变量和非静态方法
  public  static void main(String[] args) {
    //实例化Animal对象，调用类中的方法
    Animal animal = new Animal();
    int i = 5;
    String str1 = "test1";
    String str2 = "test2";
    animal.foo4(i,str1,str2);
  }
}
