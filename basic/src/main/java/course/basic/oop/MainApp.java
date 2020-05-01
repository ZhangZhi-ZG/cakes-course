package course.basic.oop;

/**
 * @author cbooy
 * @date 2020-05-01
 */
public class MainApp {

  public static void main(String[] args) {
    运行车(new 宝马("xxx","123"));
    运行车(new 奔驰("yyy","456"));
  }

  public static void 运行车(车 car) {
    car.运行();
  }

//  public static void main(String[] args) {
//    宝马 bmw = new 宝马("宝马", "5230");
//
//    bmw.操控比较好();
//    bmw.运行();
//
//    奔驰 bz = new 奔驰("奔驰", "GLC");
//    bz.内饰豪华();
//    bz.运行();
//
//    bz.hashCode();
//    bz.getClass();
//    bz.equals(null);
//  }

}
