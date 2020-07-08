package course.leetcode.sort;

import java.util.*;


/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */

public class intersectionSolutions {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {1,2};
        int[] ints = intersectionSolutions.intersection3(nums1, nums2);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
    public static int[] intersection1(int[] nums1, int[] nums2) {

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


    public static int[] intersection2(int[] nums1, int[] nums2){

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }
        int[] newNums = new int[set2.size()];
        int flag = 0;
        for (int num:set2){
            newNums[flag] = num;
            flag++;
        }
        return newNums;
    }

    /**
     * 思路：
     *      1、创建hashmap，将其中一个数据的元素作为key值添加进去，并将对应的value值初始化为0；
     *      2、判断第二组数据的元素是否存在于map中，有则将value值加一，以此来区分两个数组的重复元素；
     *      3、从map中取出value大于0的key值，存放到list中，最后循环获取即可。
     */

    public static int[] intersection3(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num,0);
        }

        for (int num2 : nums2){
            if (map.containsKey(num2)){
                map.put(num2,map.get(num2)+1);
            }
        }
        Set<Integer> keys = map.keySet();
        List<Integer> list = new ArrayList<>();
        for (int key : keys){
            if (map.get(key)>0){
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
