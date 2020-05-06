package course.basic.str;

import java.util.Date;

/**
 * 需求，Java中不支持return返回两个数据，Python是支持的，
 *
 * 就需要，就想要返回两个数据， 这时第一个想到的就是用对象来包装
 *
 *
 *
 * @author cbooy
 * @date 2020-05-02
 */
public class LocalPair1App {

  public static void main(String[] args) {
    // 正常的逻辑调用处理
    LocalPair1 pair = foo1();

    // 此时程序编辑的时候不会报错，只有到了运行时，才会报错
    // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
    // LocalPair1 pair = foo3();

    Object val1 = pair.getVal1();
    Object val2 = pair.getVal2();

    // 重点在这里
    String[] arr1 = ((String) val1).split(",");
    String[] arr2 = ((String) val2).split(",");

    for (String s : arr1) {
      System.out.println("val1," + s);
    }

    for (String s : arr2) {
      System.out.println("val2," + s);
    }

  }

  public static LocalPair1 foo1() {
    // 1.String,String ->
    LocalPair1 pair1 = new LocalPair1("abc,abc", "bcd,bcd");
    // 经过了一堆的逻辑处理
    return pair1;
  }

  public static LocalPair1 foo2() {
    // 2.String,Integer ->
    LocalPair1 pair2 = new LocalPair1("abc", 1024);
    return pair2;
  }

  public static LocalPair1 foo3() {
    // 3.Integer, Date ->
    LocalPair1 pair3 = new LocalPair1(1024, new Date());

    return pair3;
  }
}
