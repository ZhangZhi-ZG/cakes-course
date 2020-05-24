package course.basic.assignment.day01_02;

/**
 * @author zzhg
 * @date 2020-05-11
 */
public class HuiWenDemo {
    public boolean isHuiWen(String s){
        char[] css = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char cs : css) {
            sb.insert(0,cs);
        }
        return sb.toString().equals(s);
    }
}
