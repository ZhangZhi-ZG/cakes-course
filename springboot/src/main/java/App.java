import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zzhg
 * @date 2020-06-15
 */
public class App {
    public static void main(String[] args) {
        App app = new App();

        // String s = app.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        // System.out.println("s = " + s);
        String name = "zhang san";
        int[] is = new int[]{7,4,2,8,1,7,7,10};  //1,2,3,4,6  [7,4,2,8,1,7,7,10]

        List<Integer> i = app.minSubsequence(is);
        System.out.println("i = " + i);
        // System.out.println("name.indexOf(\"1\") = " + name.indexOf("1"));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){

            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length() - 1);
            }

        }
        return prefix;
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

    public int[] intersection(int[] nums1, int[] nums2) {
        return null;
    }

    public int[] disNums(int[] nums){
        int[] new_nums;

        for(int i=0;i<nums.length;i++){

        }
        return null;
    }
}
