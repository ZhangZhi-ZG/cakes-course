package course.basic.oop;

/**
 * 文件描述的抽象
 * <p>
 * 纯粹的抽象描述。
 *
 * @author cbooy
 * @date 2020-05-01
 */
public interface IFileOperator {

  /**
   * 文件打开
   */
  void open();

  /**
   * 文件读取
   */
  void read();

  /**
   * 文件关闭
   */
  void close();
}
