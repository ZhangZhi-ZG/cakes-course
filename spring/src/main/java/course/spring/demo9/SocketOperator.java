package course.spring.demo9;

public class SocketOperator implements Operator, SafeCheck {

    @Override
    public void op(String path) {
        System.out.println("SocketOperator.openSocket address = " + path);
    }

    @Override
    public void verifySafe() {
        System.out.println("SocketOperator.verifySafe");
    }

    // 需求： 为每个资源操作的方法前后都做个 警告处理==> print log
    // String openSocket(String address) {
    //     try {
    //         System.out.println("log : SocketOperator.openSocket");
    //
    //         System.out.println("SocketOperator.openSocket address = " + address);
    //
    //         System.out.println("log : SocketOperator.openSocket");
    //         return "open success";
    //     } catch (Exception e) {
    //         System.out.println("log : SocketOperator.openSocket");
    //     } finally {
    //         System.out.println("log : SocketOperator.openSocket");
    //     }
    //
    //     return null;
    // }
}