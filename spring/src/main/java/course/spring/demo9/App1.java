package course.spring.demo9;

public class App1 {

    public static void main(String[] argssss) {
        SafeCheck sc = new FileOperator();

        SafeCheck safeCheckProxy = LogProxy.getProxyInstance(sc);

        safeCheckProxy.verifySafe();
    }
}
