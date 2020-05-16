package course.basic.str;

/**
 * @author cbooy
 * @date 2020-05-02
 */
public class Dog {

  private String name = "大黄";


  private Dog() {

  }

  public static Dog of() {
    return new Dog();
  }



//  public Dog(String name) {
//    this.name = name;
//  }
//
//  public static void main(String[] args) {
//    Dog of = Dog.of();
//
//  }
}
