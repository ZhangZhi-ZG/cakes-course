package course.basic.str;

/**
 * @author cbooy
 * @date 2020-05-02
 */
public class Demo5 {

  public static void main(String[] args) {

    String str = "a,b,c,d,e,f,g";

    String[] arr = str.split(",");

    StringBuilder res = new StringBuilder();

    StringBuffer buffer = new StringBuffer();



    for (String s : arr) {
      // str1 + str2
      res.append(s).append("*");
      buffer.append(s).append("*");
    }

    System.out.println("res = " + res);
    System.out.println("buffer = " + buffer);

  }

}
