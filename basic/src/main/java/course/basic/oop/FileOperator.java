package course.basic.oop;

/**
 * 基于抽象的描述，我们来完成一些通用的方法， 对那些 不确定的，不做具体实现，继续保持抽象
 * 抽象：
 * 1、对需要做的事情的抽象，由子类进行实现；
 * 2、不可以直接对抽象进行实例化--不能new
 * 3、实例化子类的同时，也会对抽象类进行实例化
 * 4、抽象类中可以定义一些属性，共有方法，被所有子类继承共享
 *
 *
 *
 * @author cbooy
 * @date 2020-05-01
 */
public abstract class FileOperator implements IFileOperator {

  private String fileName;

  public FileOperator(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public abstract void open();

  @Override
  public void read() {
    System.out.println("读取文件:" + this.fileName + ",所有的文件读取都一样，无论是从哪里加载过来的文件，磁盘，网络。。。");
  }

  @Override
  public abstract void close();
}
