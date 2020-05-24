package course.basic.assignment.day01_02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzhg
 * @date 2020-05-11
 *
 * 判断两个集合是否有相同元素，若有则输出相同的元素
 */
public class InnerList<T> {
    public <B>List<B> innerListDemo(List<B> l1, List<T> l2){
        List<B> newList = new ArrayList<>();
        for (int i = 0; i < l1.size(); i++) {
            B s = l1.get(i);
            if (l2.contains(l1.get(i))){
                newList.add(s);
            }

        }
        return newList;
    }
}
