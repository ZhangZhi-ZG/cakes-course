package course.leetcode.sort;

public class insertSortSolutions {

    public static void main(String[] args) {
        int[] nums = {3,2,8,6,10,9,6,1};
        int[] sort = insertSortSolutions.insertSort(nums);
        for (int num : sort) {
            System.out.println("num = " + num);
        }

    }

    private static int[] sort(int[] array) {
        int n = array.length;
        /**
         *从第二位数字开始，每一个数字都试图跟它的前一个比较并交换，并重复；直到前一个数字不存在或者比它小或相等时停下来
         **/
        for (int i = 1; i < n; i++) {//从第二个数开始
            int key = array[i];
            int j = i -1;
            while (j >= 0 && array[j]>key) {
                array[j + 1] = array[j];     //交换
                j--;                                //下标向前移动
            }
            array[j+1] = key;
        }
        return array;
    }


    private static int[] insertSort(int[] nums) {
        for (int i =1;i<nums.length;i++) {
            int key = nums[i];

            int j = i-1;
            //{3,2,8,6,10,9,6,1}
            while (j>=0 && nums[j]>key) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j+1] = key;

        }



        return nums;
    }
}
