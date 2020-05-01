package course.basic.oop;

/**
 * 工人制作凳子
 *
 * @author cbooy
 * @date 2020-05-01
 */
public class Worker {

  private String name;

  public Worker(String name) {
    this.name = name;
  }

  public void 制造凳子() {
    System.out.println("工人" + this.name + "开始制作凳子");

    锯木头();

    钉钉子();

    刷油漆();

    System.out.println("制作完成!!!");
  }

  private void 锯木头() {

  }

  private void 钉钉子() {

  }

  private void 刷油漆() {

  }

}
