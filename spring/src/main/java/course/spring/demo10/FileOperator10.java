package course.spring.demo10;

import org.springframework.stereotype.Component;

@Component
public class FileOperator10 {

    public void op(String path) {
        System.out.println("demo 10  FileOperator.openFile path = " + path);
    }
}