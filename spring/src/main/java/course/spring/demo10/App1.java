package course.spring.demo10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App1 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Demo10Configuration.class);

        DiskOperator10 diskOperator10 = context.getBean(DiskOperator10.class);
        diskOperator10.testDisk("hahah");

        FileOperator10 fileOperator10 = context.getBean(FileOperator10.class);
        fileOperator10.op("hehehehe");

        SocketOperator10 socketOperator10 = context.getBean(SocketOperator10.class);
        socketOperator10.opSocket1("hehehehe");
    }
}
