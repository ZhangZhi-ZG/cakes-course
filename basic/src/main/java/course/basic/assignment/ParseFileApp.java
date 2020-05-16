package course.basic.assignment;

/**
 * @author zzhg
 * @date 2020-05-12
 */
public class ParseFileApp {



    public static void main(String[] args) {
        String file_path = "C:\\Users\\ZhiZhang\\Desktop\\students.txt";
        ParseFile pf = new ParseFile(file_path);
        pf.readFile();


    }
}
