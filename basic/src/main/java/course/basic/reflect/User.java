package course.basic.reflect;

/**
 * @author haoc
 */
// Class<User>
public class User {

  // 属性，万事万物接对象， 属性也是个对象， Field
  private String name;

  private Integer age;

  public String info;

  // 构造器，也是对象， Constructor
  public User(String name) {
    this.name = name;
  }

  public User(String name, Integer age, String info) {
    this.name = name;
    this.age = age;
    this.info = info;
  }

  // 方法， 也是可以被抽象为 对象的， Method
  public String getName() {
    return name;
  }

  public void foo1(String name, String text, int i) throws RuntimeException {

  }

  private void makeLove() {
    System.out.println("hahahaha");
  }
}
