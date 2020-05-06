package course.basic.str;

/**
 * @author cbooy
 * @date 2020-05-02
 */
public class RetMsg<T> {

  private static final Integer SUCCESS_CODE = 2000;

  private static final String SUCCESS_MSG = "success";

  private Integer errorCode;

  private String errorMsg;

  private T data;


  public RetMsg(Integer errorCode, String errorMsg, T data) {
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
    this.data = data;
  }


  //RetMsg<N>为方法的返回类型，前面的<N>标注此方法的返回值存在泛型
  public static <N> RetMsg<N> buildSuccessMsg(N data) {
    //相当于返回ret
     RetMsg<N> ret = new RetMsg<>(SUCCESS_CODE, SUCCESS_MSG, data);
    return new RetMsg<>(SUCCESS_CODE, SUCCESS_MSG, data);
  }


}
