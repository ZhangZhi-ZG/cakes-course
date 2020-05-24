package course.basic.assignment.day03;

import java.util.List;

/**
 * @author zzhg
 * @date 2020-05-23
 */
public class myApp {
    public static void main(String[] args) {
        String file_path = "C:\\Users\\ZhiZhang\\Desktop\\students.txt";
        parseFile pf = new parseFile(file_path);
        List<List<Object>> params = pf.readFile();

        String sql = "insert into tb_user(`name`,`age`) values(?,?)";
        myConn conn = new myConn();
        for (List<Object> param : params) {
            conn.updateData(sql,param);
        }


    }

}
