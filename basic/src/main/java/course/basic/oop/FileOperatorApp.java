package course.basic.oop;

import course.basic.oop.FileOperator;
import course.basic.oop.IFileOperator;
import course.basic.oop.SocketFileOperator;

/**
 * @author cbooy
 * @date 2020-05-01
 */
public class FileOperatorApp {

//  public static void main(String[] args) {
//    FileOperator fp = new FileOperator();
//  }
  public static void main(String[] args) {
    foo(new DiskFileOperator("xxx.mp4"));
  }

  public static void foo(IFileOperator fileOperator) {
    fileOperator.open();

    fileOperator.read();

    fileOperator.close();
  }

}
