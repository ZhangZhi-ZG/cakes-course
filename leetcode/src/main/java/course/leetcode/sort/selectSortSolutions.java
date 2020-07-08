package course.leetcode.sort;


/**
 * 选择排序
 *  从末尾序列中找出最小或者最大元素，记录下其索引值，然后循环进行比较最后排序
 */
public class selectSortSolutions {

    public static void main(String[] args){
        int[] nums = {3,2,8,6,10,9,6,1};
        int[] selectSort = selectSortSolutions.selectSort(nums);
        for (int num : selectSort) {
            System.out.println("num = " + num);
        }
    }

    private static int[] selectSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int min=i;
            for (int j=i+1;j<nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;

        }

        return nums;
    }
}
