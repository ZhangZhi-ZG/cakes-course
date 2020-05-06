package course.basic.str;

import java.util.Date;

/**
 * @author cbooy
 * @date 2020-05-02
 */
public class LocalPair2App {

  public static void main(String[] args) {
    LocalPair2<String, String> pair = foo1();

    String val1 = pair.getK();
    String val2 = pair.getV();

    String[] arr1 = val1.split(",");
    String[] arr2 = val2.split(",");

    for (String s : arr1) {
      System.out.println("val1," + s);
    }

    for (String s : arr2) {
      System.out.println("val2," + s);
    }

  }

  public static LocalPair2<String, String> foo1() {
    // 1.String,String ->
    LocalPair2<String, String> pair1 = new LocalPair2<>("abc,abc", "bcd,bcd");
    // 经过了一堆的逻辑处理
    return pair1;
  }

  public static LocalPair2<String, Integer> foo2() {
    // 2.String,Integer ->
    LocalPair2<String, Integer> pair2 = new LocalPair2<>("abc", 1024);
    return pair2;
  }

  public static LocalPair2<Integer, Date> foo3() {
    // 3.Integer, Date ->
    LocalPair2<Integer, Date> pair3 = new LocalPair2<>(1024, new Date());

    return pair3;
  }
}
