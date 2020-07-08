import java.lang.reflect.Array;
import java.util.*;

/**
 * @author zzhg
 * @date 2020-06-15
 */
public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] ints = {1, 1, 2, 3, 4, 3};
        int[] ints1 = {2, 1, 2, 5, 4, 3};
        int[] intersection = app.intersection(ints, ints1);
        for (int i : intersection) {
            System.out.println("i = " + i);
        }
//        String s = "leetcode";
//        String t = "practice";
//        int j = app.minSteps2(s, t);
//        System.out.println("i = " + j);


//        System.out.println("count.length = " + count.);

        // String s = app.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        // System.out.println("s = " + s);
//        String name = "zhang san";
//        int[] is = new int[]{7,4,2,8,1,7,7,10};  //1,2,3,4,6  [7,4,2,8,1,7,7,10]
//
//        List<Integer> i = app.minSubsequence(is);
//        System.out.println("i = " + i);
        // System.out.println("name.indexOf(\"1\") = " + name.indexOf("1"));
    }



    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            sum += num;
        }
        Arrays.sort(nums);
        int j = nums.length -1;
        int temp=0;
        for(int i = j;i<nums.length;i--){
            temp+=nums[i];
            if(temp <= sum / 2){
                list.add(nums[i]);

            }else{
                list.add(nums[i]);
                break;
            }
        }
        return list;
        // while(true){
        //
        //     //[7,4,2,8,1,7,7,10]->[1,2,4,7,7,7,8,10]
        //     if(sumNum(nums,j) <= sum / 2){
        //         list.add(nums[j]);
        //         j--;
        //         continue;
        //     }
        //     list.add(nums[j]);
        //     return list;
        // }

    }


    public int[] disNums(int[] nums){
        int[] new_nums;

        for(int i=0;i<nums.length;i++){

        }
        return null;
    }


    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int len1 = nums1.length;
        int len2 = nums2.length;

        for (int i = 0; i < len1; i++) {
            map.put(nums1[i],0);

            for (int j = 0; j < nums2.length; j++) {
                if (map.containsKey(nums2[j])){
                    map.put(nums2[j],map.get(nums2[j])+1);
                }
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        List<Integer> kl = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer value = entry.getValue();
            if (value>0){
                Integer key = entry.getKey();
                kl.add(key);
            }
        }

        int[] a = new int[kl.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = kl.get(i);
        }
        return a;
    }
}
