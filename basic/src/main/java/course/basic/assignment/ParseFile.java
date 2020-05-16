package course.basic.assignment;

import java.io.*;
import java.sql.*;

/**
 * @author zzhg
 * @date 2020-05-12
 *
 * 从文件读取数据，解析出来之后，存入至数据库中
 *
 */
public class ParseFile {
    private String filepath;
    private File file;


    public ParseFile(String filepath) {
        this.filepath = filepath;
    }


    public ParseFile(File file) {
        this.file = file;
    }

    public void readFile(){
        MysqlUtil my = new MysqlUtil();
        Connection conn = my.myConn();
        PreparedStatement pst = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            String sql = "insert into students(id,name,age) values (?,?,?)";
            pst = my.updateData(conn,sql);
            String line;
            int i = 0;
            while ((line = br.readLine()) != null ){
                i++;
                if(i != 1)
                {
                    String[] css = line.split(",");
                    //4、传入实际参数
                    pst.setInt(1,Integer.parseInt(css[0].trim()));
                    pst.setString(2,css[1].trim());
                    pst.setInt(3,Integer.parseInt(css[2].trim()));
                    //5、执行sql语句
                    pst.executeUpdate();
                }

            }


        } catch (FileNotFoundException e) {
            System.out.println("文件不存在！");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("文件读取失败！");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        my.closeConn(conn,pst);
        }
    }

//    public  void conMysql(){
//        try {
//            //1、加载驱动
//            Class.forName(JDBC_DRIVER);
//            //2、建立数据库连接
//            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWD);
//            //3、获得预处理对象
//            String sql = "insert into students(id,name,age) values (?,?,?)";
//            PreparedStatement psql = conn.prepareStatement(sql);
//            //4、传入实际参数
//            psql.setInt(1,2);
//            psql.setString(2,"zhang zhi");
//            psql.setInt(3,27);
//            //5、执行sql语句
//            int line = psql.executeUpdate();
//            System.out.println("line = " + line);
//            //6、关闭数据库连接
//            conn.close();
//            psql.close();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
