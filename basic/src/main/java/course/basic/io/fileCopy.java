package course.basic.io;

import java.io.*;

public class fileCopy {
    public static void main(String[] args) {
        String sourceFilePath = "C:\\Workspace\\cakes-course\\0.notes\\day01.md";
        String targetFilePath = "C:\\Users\\ZhiZhang\\Desktop\\xxx.md";
        Copy(sourceFilePath,targetFilePath);
    }



    public static void Copy(String sourceFile, String targetFile){

        File file = new File(sourceFile);
        Reader reader = null;

        try {
            reader = new FileReader(file);
            Writer writer = new FileWriter(targetFile);
            int len;
            char[] buf = new char[256];
//            StringBuilder sb = new StringBuilder();
            while ((len = reader.read(buf)) != -1){
                writer.write(buf);
                writer.flush();
            }
//            System.out.println("sb = " + sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
