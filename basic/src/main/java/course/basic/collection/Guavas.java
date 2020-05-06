package course.basic.collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author haoc
 */
public class Guavas {

  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    Map<String, String> map1 = Maps.newHashMap();

    List<String> list = new ArrayList<>();
    List<String> list1 = Lists.newArrayList();

    Set<String> set = new HashSet<>();
    Set<String> set1 = Sets.newHashSet();
  }

}
