package course.auto.framework.cases;

import course.auto.framework.annotation.*;
import course.auto.framework.cases.model.NewOrder;
import course.auto.framework.cases.model.NewUser;
import org.junit.jupiter.api.BeforeEach;

public class TestApiPay {

    private String orderId;
    private NewUser payer;
    private NewUser payee;
    private Long amount;

    @BeforeEach
    public void init() {
        orderId = "xxx";
        amount = 1024L;
    }

    @AutoTest
    @CaseTitle("支付宝订单创建接口")
    @CheckPoint("订单落地信息准确")
    @CheckPoint("订单状态机==INIT")
    @CaseDesc(desc = "主流程用例，正常走通全链路", owner = "zhangsan")
    @CaseTag(key = "business", val = "pay")
    @CaseTag(key = "channel", val = "apipay")
    // @EnvCheck("pay", "order", "gateway")
    public void testCreateOrder() {
        // 1.准备环境,清理环境
        // 拿到具体的profile，也知道模块，所以就去check在指定profile环境中的具体模块的保活接口.
        // EnvCheck.check("pay", "order", "gateway");

        // 2.准备数据
        NewOrder newOrder = new NewOrder();
        newOrder.setOrderId(orderId);

        // 3.构造请求

        // 4.向接口发请求

        // 5.拿到接口response做断言

        // 6.断言db相关逻辑

        // 7.清理
    }
}
