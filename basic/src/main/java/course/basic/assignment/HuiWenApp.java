package course.basic.assignment;



/**
 * @author zzhg
 * @date 2020-05-11
 * 作业：
 *  给定一个字符串，判断其是否回文
 *
 */
public class HuiWenApp {
    public static void main(String[] args) {
        String s = "11b11";
        HuiWenDemo demo = new HuiWenDemo();
        boolean b = demo.isHuiWen(s);
        System.out.println("b = " + b);

    }
}
