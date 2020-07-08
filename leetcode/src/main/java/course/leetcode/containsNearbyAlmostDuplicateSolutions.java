package course.leetcode;

public class containsNearbyAlmostDuplicateSolutions {

    public static void main(String[] args) {
        int[] nums = {1,5,9,1,5,9};
        int k = 2;
        int t = 3;
        boolean b = containsNearbyAlmostDuplicateSolutions.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println("b = " + b);
    }
    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j<nums.length;j++ ) {
                if (Math.abs(nums[i]-nums[j]) <= t && Math.abs(i - j) <= k) {
                    flag = true;
                }
            }
        }
        return flag;
    }
}
