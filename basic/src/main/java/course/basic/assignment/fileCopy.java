package course.basic.assignment;

import java.io.*;

/**
 * 给定路径后完成文件的复制
 */

public class fileCopy {
    public static void main(String[] args) {
        String sourceFilePath = "C:\\Workspace\\cakes-course\\0.notes\\day02.md";
        String targetFilePath = "C:\\Users\\ZhiZhang\\Desktop\\xxx02.md";
        fileCopy fc = new fileCopy(sourceFilePath, targetFilePath);

        fc.copy();
    }

    private String sourceFile;

    private String targetFile;

    public fileCopy(String sourceFile, String targetFile) {
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
    }

    public void copy() {

//        File file = new File(sourceFile);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile));
            String res;
            while ((res = reader.readLine()) != null) {
                writer.write(res + "\n");
                writer.flush();
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在！" + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("文件读取失败！" + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
