package course.basic.oop;

/**
 * @author cbooy
 * @date 2020-05-01
 */
public class 车 {

  private String 品牌;

  private String 型号;

  public 车() {
  }

  public 车(String 品牌, String 型号) {
    this.品牌 = 品牌;
    this.型号 = 型号;
  }

  public void 运行() {
    System.out.println("品牌=" + this.品牌 + "的车在跑");
  }
}
