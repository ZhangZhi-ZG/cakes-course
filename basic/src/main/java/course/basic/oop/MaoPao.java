package course.basic.oop;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaoPao {
    public Integer[] nums(Integer[] numLists) {
        //[3,1,4,2,7,5]
        for (int i=0;i<numLists.length-1;i++) {
            for (int j = i+1 ; j<numLists.length;j++){
                if (numLists[i]>numLists[j]){
                    int temp = numLists[j];
                    numLists[j] = numLists[i];
                    numLists[i] = temp;
                }
            }
        }

        return numLists;
    }

    public static void main(String[] args) {

        String str = "hello world";
        str.contains("hello");
        MaoPao nums = new MaoPao();
        System.out.println("nums = " + nums);
        Integer[] num_lists = new Integer[]{2,4,57,3,43,323,545,767,323,56,434};
        System.out.println(Arrays.toString(nums.nums(num_lists)));
    }
}
