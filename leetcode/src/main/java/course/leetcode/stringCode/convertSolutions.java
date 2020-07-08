package course.leetcode.stringCode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 */


public class convertSolutions {
    public static void main(String[] args) {
        String s = "AB";
        String convert = convert(s, 1);
        System.out.println("convert = " + convert);
    }
    private static String convert(String s, int numRows) {

        if (s == null || numRows==1 || s.length() <=1){
            return s;
        }
        int rows = Math.min(s.length(),numRows);
        StringBuilder[] arrs = new StringBuilder[rows];
        for (int i = 0; i < rows; i++) {
            arrs[i] = new StringBuilder();
        }
        boolean flag = false;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            arrs[j].append(s.charAt(i));
            if (j==0 || j == rows - 1){
                flag = !flag;
            }
            if (flag) {
                j++;
            }else{
                j--;
            }
        }

        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            newString.append(arrs[i]);
        }

        return newString.toString();


    }
}
