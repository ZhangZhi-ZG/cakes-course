package course.basic.collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.*;

/**
 * @author haoc
 */
public class Guavas {

    public static void main(String[] args) {

        List<String> emptyList = Collections.emptyList();
        String name = "zhang san";
        List<String> singletonList = Collections.singletonList(name);
        singletonList.add(1, "li si");

        System.out.println("singletonList = " + singletonList);

    }


    public static void foo1() {
        Map<String, String> map = new HashMap<>();

        map.put(null,null);
        Map<String, String> map1 = Maps.newHashMap();

        List<String> list = new ArrayList<>();
        List<String> list1 = Lists.newArrayList();

        Set<String> set = new HashSet<>();
        Set<String> set1 = Sets.newHashSet();
    }

}
