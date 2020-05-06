package course.basic.str;

import java.util.Date;
import org.apache.commons.lang3.tuple.Pair;

/**
 * @author cbooy
 * @date 2020-05-02
 */
public class CommonsPair {

  public static void main(String[] args) {
    Pair<String, String> pair1 = Pair.of("abc", "bcd");
    pair1.getKey();
    pair1.getLeft();

    pair1.getValue();
    pair1.getRight();

    Pair<String, Integer> pair2 = Pair.of("abc", 1024);
    Pair<Date, Integer> pair = Pair.of(new Date(), 1024);
    Pair<Date, Integer> pair3 = Pair.of(new Date(), 1024);
  }

}
