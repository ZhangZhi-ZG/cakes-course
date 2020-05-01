package course.basic.oop;

/**
 * 磁盘文件操作
 *
 * @author cbooy
 * @date 2020-05-01
 */
public class DiskFileOperator extends FileOperator {

  public DiskFileOperator(String fileName) {
    super(fileName);
  }

  // 打开文件
  @Override
  public void open() {
    System.out.println("DiskFileOperator.open");
  }

  // 关闭文件
  @Override
  public void close() {
    System.out.println("DiskFileOperator.close");
  }
}
