package course.basic.common;

/**
 * @author cbooy
 * @date 2020-05-01
 */
public class Demo1 {

  public static void main(String[] args) {

//    int i = 1024;
//
//    long l = 1024;
//
//    float f = 3.14f;
//
//    int[] arr = new int[5];

    int[] arr1 = new int[]{1, 2, 3, 4, 5};

    /**
     * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:
     */
    arr1[10] = 1024;
  }

}
