package course.basic.oop;

/**
 * 网络文件操作
 *
 * @author cbooy
 * @date 2020-05-01
 */
public class SocketFileOperator extends FileOperator {

  public SocketFileOperator(String fileName) {
    super(fileName);
  }

  // 打开文件
  @Override
  public void open() {
    System.out.println("SocketFileOperator.open");
  }

  // 关闭文件
  @Override
  public void close() {
    System.out.println("SocketFileOperator.close");
  }
}
