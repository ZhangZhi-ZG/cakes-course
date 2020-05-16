package course.basic.str;

import java.util.Date;

/**
 * @author cbooy
 * @date 2020-05-02
 */
public class LocalPair2App {

  public static void main(String[] args) {

    //调用数据类型为String的方法，实例化时必须传入String的数据类型
    LocalPair2<String, String> pair = foo1();
    LocalPair2<String, Integer> pair2 = foo2();
    LocalPair2<Integer, Date> pair3 = foo3();

    //实例化时，数据类型不符，不用运行直接报错
    //LocalPair2<String, String> pair1 = foo2();
    //这时属性的返回值类型也发生变化，类型为String
    String val1 = pair.getK();
    String val2 = pair.getV();

    //这里也不需要进行数据类型的强制转换
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
