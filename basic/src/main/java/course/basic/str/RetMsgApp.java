package course.basic.str;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author cbooy
 * @date 2020-05-02
 */
public class RetMsgApp {

  public static void main(String[] args) {
    RetMsg<String> retMsg = RetMsg.buildSuccessMsg("hello");
    RetMsg<Date> retMsg2 = RetMsg.buildSuccessMsg(new Date());
    List<String> l = new ArrayList<>();
    RetMsg<String> retMsg1 = new RetMsg<>(2000, "success", "hello");
  }

}
