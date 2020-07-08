package course.basic.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

/**
 * @author haoc
 */
public class IODemo1 {

  public static void main(String[] args) throws Exception {
    // testReadFile1();

//    testWriteFile1();

//    normalReader1();

    bufferedReader1();
  }

  private static void bufferedReader1() {
    String filePath = "D:\\workspace\\cakes-course\\0.notes\\day01.md";
    File file = new File(filePath);
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(file));

      String res;
      StringBuilder sb = new StringBuilder();
      while ((res = reader.readLine()) != null) {
        sb.append(res).append("\n");
      }

      String val = sb.toString();

      System.out.println("val = " + val);
    } catch (FileNotFoundException e) {
      System.out.println("这个文件不存在呀，" + e.getMessage());
      throw new RuntimeException(e);
    } catch (IOException e) {
      System.out.println("文件读取失败了," + e.getMessage());
      throw new RuntimeException(e);
    } finally {
      if (null != reader) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void normalReader1() {
    String filePath = "/Users/haoc/course/code/cakes-course/0.notes/day01.md";
    File file = new File(filePath);
    Reader reader = null;
    try {
      reader = new FileReader(file);

      int len;
      char[] buf = new char[256];

      StringBuilder sb = new StringBuilder();
      while ((len = reader.read(buf)) != -1) {
        String str = new String(buf, 0, len);
        sb.append(str);
      }

      String val = sb.toString();

      System.out.println("val = " + val);
    } catch (FileNotFoundException e) {
      System.out.println("这个文件不存在呀，" + e.getMessage());
      throw new RuntimeException(e);
    } catch (IOException e) {
      System.out.println("文件读取失败了," + e.getMessage());
      throw new RuntimeException(e);
    } finally {
      if (null != reader) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }


  // try-catch-finally
  public static void normalRead1() {
    String filePath = "/Users/haoc/course/code/cakes-course/0.notes/day01.md";

    InputStream ins = null;
    try {
      File file = new File(filePath);
      ins = new FileInputStream(file);

      int len;
      byte[] buf = new byte[256];

      StringBuilder sb = new StringBuilder();
      while ((len = ins.read(buf)) != -1) {
        String str = new String(buf, 0, len);
        sb.append(str);
      }
    } catch (FileNotFoundException e) { // if e == FileNotFoundException
      System.out.println("这个文件不存在呀，" + e.getMessage());
      throw new RuntimeException(e);
    } catch (IOException e) {
      System.out.println("文件读取失败了," + e.getMessage());
      throw new RuntimeException(e);
    } finally {
      if (null != ins) {
        try {
          ins.close();
        } catch (IOException e) {
          System.out.println("流关闭失败了," + e.getMessage());
        }
      }
    }

  }

  public static void testWriteFile1() throws Exception {
    String filePath = "/Users/haoc/course/temp/xxxx.md";
    File file = new File(filePath);
    OutputStream ous = new FileOutputStream(file);

    for (int i = 0; i < 1000; i++) {
      String str = "hello java io" + i + "\n";
      ous.write(str.getBytes());
    }

    ous.flush();
  }

  public static void testReadFile1() throws Exception {
    String filePath = "/Users/haoc/course/code/cakes-course/0.notes/day01.md";
    File file = new File(filePath);
    InputStream ins = new FileInputStream(file);

    int len;
    byte[] buf = new byte[256];

    StringBuilder sb = new StringBuilder();
    while ((len = ins.read(buf)) != -1) {
      String str = new String(buf, 0, len);
//      System.out.println(str);
      sb.append(str);
    }

    //
    System.out.println("读取完毕!!!");
    System.out.println(sb.toString());
  }

}
