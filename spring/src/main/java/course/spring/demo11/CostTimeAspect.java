package course.spring.demo11;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CostTimeAspect {

    @Pointcut("execution(public * course.spring.demo11.*.*(..))")
    public void costTimePointCut() {

    }

    @Around("costTimePointCut()")
    public Object doCostTime(ProceedingJoinPoint point) throws Throwable {
        try {
            long startTime = System.currentTimeMillis();

            Object result = point.proceed();

            long endTime = System.currentTimeMillis();

            System.out.println("cost time:" + (endTime - startTime));
            return result;
        } catch (Throwable throwable) {
            throw throwable;
        }
    }
}
