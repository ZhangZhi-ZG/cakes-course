package course.leetcode.sort;

import java.util.ArrayList;
import java.util.List;

public class countSortSolutions {

    public static void main(String[] args) {
        int[] nums = {3,2,8,6,10,9,6,1};
        int[] sort = countSortSolutions.countSort(nums,10);
        for (int i : sort) {
            System.out.println("i = " + i);
        }

    }

    private static int[] countSort(int[] nums,int k) {
        int[] count = new int[k+1];
        for (int num : nums) {
            count[num] ++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k + 1; i++) {
            if (count[i]>=1) {
                for (int j = 0; j < count[i]; j++) {
                    list.add(i);
                }
            }
        }

        int[] newNums = new int[list.size()];

        for (int i = 0; i < newNums.length; i++) {
            newNums[i] = list.get(i);
        }


        return newNums;
    }
}
