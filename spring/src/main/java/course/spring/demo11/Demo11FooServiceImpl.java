package course.spring.demo11;

import org.springframework.stereotype.Service;

@Service
public class Demo11FooServiceImpl implements Demo11FooService {

    @Override
    public void foo() {
        // 加个前置处理器，在这里 将流量复制一份，要么存db, 要么发mq出去，要么按照格式落日志。
        System.out.println("Demo11FooServiceImpl.foo................");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void foo1() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Demo11FooServiceImpl.foo1");
    }
}
