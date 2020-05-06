package course.basic.str;

/**
 * @author cbooy
 * @date 2020-05-02
 */
public class LocalPair3<A, B, C> {

  private A a;
  private B b;
  private C c;

  public LocalPair3(A a, B b, C c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public A getA() {
    return a;
  }

  public B getB() {
    return b;
  }

  public C getC() {
    return c;
  }
}
