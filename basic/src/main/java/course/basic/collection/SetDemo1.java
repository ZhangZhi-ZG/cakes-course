package course.basic.collection;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import java.util.HashSet;
import java.util.Set;

/**
 * @author haoc
 */
public class SetDemo1 {

  public static void main(String[] args) {
//    test1();
    test2();
  }

  public static void test2() {
    Set<String> set1 = new HashSet<>();
    set1.add("a");
    set1.add("b");
    set1.add("c");
    set1.add("d");

    Set<String> set2 = new HashSet<>();
    set2.add("a");
    set2.add("b");
    set2.add("x");
    set2.add("y");

    //并集
    SetView<String> unionSetView = Sets.union(set1, set2);
    Set<String> unionSet = unionSetView.immutableCopy();
    System.out.println("unionSet = " + unionSet);
    //差集
    SetView<String> diffSetView = Sets.difference(set2, set1);
    Set<String> diffSet = diffSetView.immutableCopy();
    System.out.println("diffSet = " + diffSet);

    //交集
    Set<String> interSet = Sets.intersection(set2, set1);
//    Set<String> interSet = interSetView.immutableCopy();
    System.out.println("interSet = " + interSet);

    // 这里是我个人的习惯，将新集合做了一个 不可改变 复制，新集合即不可再被修改，
//    Set<String> ssss = Sets.intersection(set2, set1).immutableCopy();
//    ssss.add("hello");
  }

  public static void test1() {
    Set<String> set = new HashSet<>();
    set.add("a");
    set.add("a");
    set.add("a");
    set.add("b");

    System.out.println("set = " + set);

    for (String s : set) {
      System.out.println("s = " + s);
    }
  }

}
