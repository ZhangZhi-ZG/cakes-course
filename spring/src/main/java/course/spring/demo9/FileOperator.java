package course.spring.demo9;

public class FileOperator implements Operator, SafeCheck {

    @Override
    public void op(String path) {
        System.out.println("FileOperator.openFile path = " + path);
    }

    @Override
    public void verifySafe() {
        System.out.println("FileOperator.verifySafe");
    }
}