package course.basic.common;

/**
 * @author cbooy
 * @date 2020-05-01
 */
public class Demo3 {

  public static void main(String[] args) {
    /**
     * 算术运算: +,-,*,/,++,–-
     * 赋值运算: =,+=,-=
     * 比较运算: ==,!=,<,>,<=,>=
     * 逻辑运算: &&,||,!
     * 三元运算: statement?val1:val2;
     */

    // 注意区别
    int i = 1024;
    i++;  // 先加
    ++i;  // 先用

    // == 和 =
    int b = 2048;
    if (b == i) {

    }

    // == 与 equals的区别
    Integer i1 = 1024;
    Integer i2 = 1024;
    if (i1 == i2) {

    }

    // && 所有表达式都为true,结果才为true
    // || 只要有一个为true, 结果就是true
    // if (statement1 && stemenet2 && stement3)


    // 三元运算: statement?val1:val2;
//    if (statement){
//      return val1;
//    }else {
//      return val2;
//    }

  }

}
