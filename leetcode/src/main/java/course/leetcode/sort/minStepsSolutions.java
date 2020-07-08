package course.leetcode.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。
 *
 * 返回使 t 成为 s 的字母异位词的最小步骤数。
 *
 * 字母异位词 指字母相同，但排列不同（也可能相同）的字符串。\
 *
 * 示例 1：
 * 输出：s = "bab", t = "aba"
 * 输出：1
 * 提示：用 'b' 替换 t 中的第一个 'a'，t = "bba" 是 s 的一个字母异位词。
 *
 * 解题思路：
 *     1、两个字符串长度必须相等，且都不为空
 *     2、比较两个字符串，完全相同字符的个数
 */

public class minStepsSolutions {

    public static void main(String[] args) {
        String s = "leetcode";
        String t = "practice";
        minStepsSolutions solutions = new minStepsSolutions();
        int steps = solutions.minSteps2(s, t);
        System.out.println("steps = " + steps);
    }

    //方法一
    public int minSteps(String s, String t) {
        if (s.length() != t.length() || s.length() == 0){
            return -1;
        }

        Map<String,Integer> sm = new HashMap<>();
        Map<String,Integer> tm = new HashMap<>();

        int stime =1;
        int ttime =1;

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (sm.containsKey(String.valueOf(sc))) {
                int value = sm.get(String.valueOf(sc));
                sm.put(String.valueOf(sc), value + 1);
            } else {
                sm.put(String.valueOf(sc), stime);
            }
            if (tm.containsKey(String.valueOf(tc))) {
                int value = tm.get(String.valueOf(tc));
                tm.put(String.valueOf(tc), value + 1);
            } else {
                tm.put(String.valueOf(tc), ttime);
            }
        }

        int steps=0;


        for (String sk : sm.keySet()) {
            if (!tm.containsKey(sk)){
                steps+=sm.get(sk);
            }else if (tm.containsKey(sk) && sm.get(sk)>tm.get(sk)){
                steps+=sm.get(sk)-tm.get(sk);
            }

        }


        return steps;
    }
    //方法二

    /**
     * 1、首先定义个用法存放26个英文字母的整数数组，固定大小为26个字节；
     * 2、对字符串进行循环，获取字符串中每个字符出现的次数--s.charAt(i)-'a'代表s中字符与a的ASCII码相减，结果为0代表当前字符为字母a，一次类推
     * 3、scount[s.charAt(i)-'a']++ --->统计字符出现的次数，每出现一次，scount数组当前元素数值加一，以此来达到统计次数的作用
     *
     */
    public int minSteps1(String s, String t) {
        int[] scount = new int[26];
        int[] tcount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            scount[s.charAt(i)-'a']++;
            tcount[t.charAt(i)-'a']++;
        }
        int steps = 0;
        for (int i = 0; i < scount.length; i++) {
            if (scount[i] > tcount[i]) {
                steps += scount[i] - tcount[i];
            }

        }
        return steps;
    }

    //方法三

    /**
     * 在方法二基础上，对t字符串重复出现的字符进行减一
     */
    public int minSteps2(String s, String t) {
        int[] count = new int[26];
        int length = s.length();

        for(int i=0;i<length;i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        int setps = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i]>0){
                setps+=count[i];
            }
        }
        return setps;
    }
}
