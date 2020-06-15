package course.spring.demo9;

public class App {

    public static void main(String[] argssss) {
        // Operator fileOperator = new FileOperator();

        Operator operator = new FooOperator();

        Operator proxyInstance = LogProxy.getProxyInstance(operator);

        proxyInstance.op("hahahahah");
    }
}
