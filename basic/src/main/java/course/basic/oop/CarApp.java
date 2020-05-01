package course.basic.oop;

/**
 * @author cbooy
 * @date 2020-05-01
 */
public class CarApp {

  public static void main(String[] args) {
    // Exception in thread "main" java.lang.NullPointerException
    Car 小车车 = null;
    小车车.跑(300);
  }

  public void test1() {

    // Car 是我们定义的一个类，new Car()之后，小车车=新建一个对象之后的名字
    Car 小车车 = new Car();
    小车车.跑(300);
    int i = 小车车.获取里程数();
    System.out.println(i);

    //
    Class<Car> clazz = Car.class;
  }

}
