package course.spring.demo10;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect  // 声明切面
public class LogPointcut {

    // 表示的是 我们的目标作用的点是啥， 比如当前的目标是 在包=course.spring.demo10之下
    // 的所有类，之下的 所有方法的，任意参数。。。。但是方法的权限是 public
    @Pointcut("execution(public * course.spring.demo10.*.op*(..))")  // 切点
    public void logPointcut() {

    }

    // 注意要把() 带着
    @Before("logPointcut()")  // 通知，前置通知
    public void logBefore() {
        // 织入
        System.out.println("LogPointcut.logBefore ........");
    }

    @After("logPointcut()")  // 通知，后置通知
    public void logAfter() {
        //
        System.out.println("LogPointcut.logAfter ........");
    }

    @AfterThrowing("logPointcut()") // 通知，异常通知
    public void afterThrow() {
        //
        System.out.println("LogPointcut.afterThrow ........");
    }
}
