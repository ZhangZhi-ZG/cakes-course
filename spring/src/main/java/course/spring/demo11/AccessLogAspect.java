package course.spring.demo11;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AccessLogAspect {

    @Pointcut("execution(public * course.spring.demo11.Demo11FooServiceImpl.*(..))")
    public void accessLogPointCut() {

    }

    /**
     * 环绕通知
     *
     * 感受下，是不是其他几个通知，整合在一起， 就是环绕通知？？？
     */
    @Around("accessLogPointCut()")
    public Object accessLogAround(ProceedingJoinPoint point) {
        try {
            System.out.println("AccessLogAspect.accessLogAround .... before");
            Object result = point.proceed();
            System.out.println("AccessLogAspect.accessLogAround .... after");
            return result;
        } catch (Throwable throwable) {
            System.out.println("AccessLogAspect.accessLogAround .... error");
            throw new IllegalStateException(throwable);
        } finally {
            System.out.println("AccessLogAspect.accessLogAround .... finally");
        }
    }
}
