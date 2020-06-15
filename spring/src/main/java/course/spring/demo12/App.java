package course.spring.demo12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        // ApplicationContext context = new AnnotationConfigApplicationContext(Demo12Conf.class);
        // Demo12ServiceImpl service = context.getBean(Demo12ServiceImpl.class);
        //
        // service.test();
        int[] ints = {2, 7, 11, 15};
        int target = 9;
        int[] index = twoSum(ints, target);
        System.out.println("index = " + index);
        List<String> strings = Arrays.asList("zhang san", "li si");
        System.out.println("strings = " + strings);
    }

    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int com = target - nums[i];
            if (map.containsKey(com)) {
                return new int[] {map.get(com),i};
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("参数个数不正确");
    }
}
