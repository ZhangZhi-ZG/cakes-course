package course.basic.oop;

/**
 * 汽车类
 * .class 文件地址: /cakes-course/basic/out/production/classes/course/basic/oop/Car.class
 * @author cbooy
 */
public class Car {

  // 属性 & 字段
  int 里程数 = 250;
  int 车门数 = 4;

  public Car(int 里程数, int 车门数) {
    this.里程数 = 里程数;
    this.车门数 = 车门数;
  }

  public Car() {
  }

  // 行为 & 方法 & 函数
  void 跑(int num) {
    System.out.println("汽车再跑，跑了" + num + "公里.");

    里程数 += num;
  }

  void 开门() {
    System.out.println("开的具体哪个门");
  }

  int 获取里程数() {
    return 里程数;
  }
}
