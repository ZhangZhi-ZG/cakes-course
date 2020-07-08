package course.leetcode.testDemo;


import java.io.*;

public  class FileOperatorDemo {

    public static void main(String[] args) {
        String fileName = "D:\\workspace\\cakes-course\\0.notes\\day01.md";
        File file = new File(fileName);
        readFile1(file);
    }
    //被final修饰的方法可以被继承，但是不能被重写，只能被重载
    public final void readFile(File file){
        try (BufferedReader br = new BufferedReader(new FileReader(file))){

            String line;
            StringBuilder sb = new StringBuilder();
            while((line = br.readLine())!=null){
                sb.append(line).append("\n");
            }

            System.out.println("sb.toString() = " + sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile1(File file){

        FileReader reader=null;
        try {
            reader = new FileReader(file);
            int len;
            char[] res = new char[256];
            StringBuilder sb = new StringBuilder();
            while ((len = reader.read(res) )!= -1){
                String data = new String(res, 0, len);
                sb.append(data);
            }
            String s = sb.toString();
            System.out.println("s = " + s);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
