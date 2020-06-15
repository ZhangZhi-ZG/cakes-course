package course.spring.demo10;

import org.springframework.stereotype.Component;

@Component
public class SocketOperator10 {

    public void opSocket1(String path) {
        System.out.println("demo 10  SocketOperator10.opSocket1 path = " + path);
    }

    public void opSocket2(String path) {
        System.out.println("demo 10  SocketOperator10.opSocket2 path = " + path);
    }

    protected void opSocket3(String path) {
        System.out.println("demo 10  SocketOperator10.opSocket3 path = " + path);
    }
}