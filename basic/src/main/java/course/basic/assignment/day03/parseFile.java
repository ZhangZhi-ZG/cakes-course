package course.basic.assignment.day03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zzhg
 * @date 2020-05-23
 */
public class parseFile {
    private String file_path;
    private File file;

    public parseFile(String file_path) {
        this.file_path = file_path;
    }

    public parseFile(File file) {
        this.file = file;
    }

    public List<List<Object>> readFile(){
        List<List<Object>> endList = null;
        try (BufferedReader bf = new BufferedReader(new FileReader(file_path))){
            String line;
            int i = 0;
            endList = new ArrayList<>();

            while ((line = bf.readLine()) !=null){
                List<Object> newList = new ArrayList<>();
                i ++;
                if (i!=1){
                    String[] ss = line.split(",");
                    int age = Integer.parseInt(ss[2].trim());
                    newList.add(ss[1].trim());
                    newList.add(age);
                    endList.add(newList);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在！");
            throw new RuntimeException();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return endList;
    }
}
