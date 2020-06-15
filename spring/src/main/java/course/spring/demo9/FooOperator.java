package course.spring.demo9;

public class FooOperator implements Operator {

    @Override
    public void op(String path) {
        System.out.println("FooOperator.op address = " + path);
    }
}