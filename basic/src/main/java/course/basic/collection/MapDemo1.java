package course.basic.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author haoc
 */
public class MapDemo1 {

  public static void main(String[] args) {
//    test1();

//    test2();

    test3();
  }

  public static void test3() {
    Map<String, String> map = new HashMap<>();
    map.put("key1", "val1");
    map.put("key2", "val2");

    String val1 = map.getOrDefault("key1", "hello");
    System.out.println("val1 = " + val1);

    String val2 = map.getOrDefault("kkkk", "hello");
    System.out.println("val2 = " + val2);

    String val3 = map.get("jjj");
    System.out.println("val3 = " + val3);
  }

  public static void test2() {
    Map<String, String> map = new HashMap<>();
    map.put("key1", "val1");
    map.put("key2", "val2");

    Set<Entry<String, String>> entries = map.entrySet();
    for (Entry<String, String> entry : entries) {
      System.out.println("key=" + entry.getKey() + ", val=" + entry.getValue());
    }

    // 不用纠结， 等到学习java8的时候 就明白了了
    map.forEach((k, v) -> System.out.println("key=" + k + ", val=" + v));

  }

  public static void test1() {
    Map<String, String> map = new HashMap<>();

    map.put("key", "val1");
    map.put("key", "val2");

    String val = map.get("key");
    System.out.println("val = " + val);
  }
}
