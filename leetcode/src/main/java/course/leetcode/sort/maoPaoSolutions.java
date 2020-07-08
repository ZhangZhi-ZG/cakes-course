package course.leetcode.sort;

/**
 * 冒泡排序
 */

public class maoPaoSolutions {

    public static void main(String[] args) {
        int[] nums = {3,2,8,6,10,9,6,1};
        int[] sort = maoPaoSolutions.maoPaoSort(nums);
        for (int num : sort) {
            System.out.println("num = " + num);
        }
    }

    private static int[] maoPaoSort(int[] nums){

        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]>nums[j]){
                    int temp = nums[j];
                    nums[j]=nums[i];
                    nums[i] = temp;
                }
            }
        }


        return nums;
    }
}
