package course.basic.oop;

/**
 * @author cbooy
 * @date 2020-05-01
 */
public class OrderApp {

  public static void main(String[] args) {
    new Order();
    new Order(2014L);
    new Order(2014L, "1234");
    new Order(2014L, "1234", "5678");
  }

}
