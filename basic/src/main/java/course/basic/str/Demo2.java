package course.basic.str;

/**
 * @author cbooy
 * @date 2020-05-02
 */
public class Demo2 {


  /**
   * 面试题:
   * 1.以下两种方式，在定义上有什么区别?
   * 2.如何证明？
   */

  public  static void main(String[] args) {
    //存储在常量池-通过.class字节码文件可以看到
    String str1 = "hello world";
    //存储在堆内存中
    String str2 = new String("hello world");
    System.out.println("str1 = " + str1);
  }

}
