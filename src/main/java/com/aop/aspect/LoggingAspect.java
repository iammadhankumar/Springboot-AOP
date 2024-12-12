package com.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * Aspect for logging method execution in the application.
 * 
 * This aspect demonstrates three types of AOP advices:
 * - `@Before`: Executes before the method.
 * - `@After`: Executes after the method.
 * - `@Around`: Wraps around the method to execute custom logic before and after method execution.
 */
@Aspect
@Component
public class LoggingAspect {

    /**
     * Before advice: Executes before any method in `MyService` is invoked.
     * Used to log or perform operations prior to method execution.
     */
    @Before("execution(* com.aop.service.MyService.*(..))")
    public void logBefore() {
        System.out.println("Executing method: Log Before Advice");
    }

    /**
     * After advice: Executes after any method in `MyService` completes.
     * Used to log or perform operations after method execution, regardless of its outcome.
     */
    @After("execution(* com.aop.service.MyService.*(..))")
    public void logAfter() {
        System.out.println("Method execution completed: Log After Advice");
    }

    /**
     * Around advice: Wraps the execution of any method in `MyService`.
     * Used to execute custom logic both before and after the method execution.
     * 
     * @param joinPoint provides access to the method being intercepted.
     * @return the result of the intercepted method's execution.
     * @throws Throwable if the intercepted method throws an exception.
     */
    @Around("execution(* com.aop.service.MyService.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Advice: Before Method Execution");
        
        // Proceed with the method execution
        Object result = joinPoint.proceed();
        
        System.out.println("Around Advice: After Method Execution");
        return result;
    }
}
