package course.auto.framework.cases.api;

import course.auto.framework.cases.model.NewOrder;
import course.auto.framework.cases.model.RetMsg;

public class OrderController {

    public RetMsg createOrder(NewOrder order) {
        System.out.println("order = " + order);
        return new RetMsg();
    }
}
