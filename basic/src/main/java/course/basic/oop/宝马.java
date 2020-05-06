package course.basic.oop;

/**
 * @author cbooy
 * @date 2020-05-01
 */
public class 宝马 extends 车 {

  /**
   *
   * 继承：
   * 1、子类拥有父类的一切属性及方法，但是被private修饰过的属性及方法不能直接调用
   * 2、当创建子类对象时，同时也会新建一个父类对象
   * 3、super关键字代表父类对象的指针
   *
   */
  public 宝马(String 品牌, String 型号) {
    super(品牌, 型号);
  }

  public void 操控比较好() {

  }
}
