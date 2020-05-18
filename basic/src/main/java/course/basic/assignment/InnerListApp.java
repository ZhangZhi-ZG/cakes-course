package course.basic.assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzhg
 * @date 2020-05-11
 */
public class InnerListApp {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l1.add("a");
        l1.add("b");
        l1.add("x");
        l1.add("y");

//        l2.add(1);
//        l2.add("x");
//        l2.add("c");
//        l2.add("b");
//        l2.add(1);
        l2.add(1);
        l2.add(2);
        l2.add(3);
        l2.add(4);
        InnerList list = new InnerList();
        List<String> demo = list.innerListDemo(l1,l2);
        System.out.println("demo = " + demo);

    }
}
