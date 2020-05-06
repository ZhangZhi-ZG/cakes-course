package course.basic.str;

/**
 * val1,val2
 *
 * @author cbooy
 * @date 2020-05-02
 */
public class LocalPair2<K, V> {

  private K k;

  private V v;

  public LocalPair2(K k, V v) {
    this.k = k;
    this.v = v;
  }

  public K getK() {
    return k;
  }

  public V getV() {
    return v;
  }
}
