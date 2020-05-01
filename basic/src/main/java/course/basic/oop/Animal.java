package course.basic.oop;

/**
 * @author cbooy
 * @date 2020-05-01
 */
public class Animal {

  void foo1() {

  }

  int foo2() {
    return -1;
  }

  int foo3(int i1) {
    return i1 + 1024;
  }

  int foo3(int i1, String str) {
    return i1 + 1024;
  }

  void foo4(int i1, String... strs) {
    String[] ss = strs;
  }

  void foo5() {
    foo4(1, "a");
    foo4(1, "a", "b");
    foo4(1, "a", "b", "c");
  }

}
