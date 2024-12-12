package com.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * Aspect for measuring the execution time of methods in the service layer.
 * 
 * This aspect uses the `@Around` advice to intercept method execution,
 * calculate the time taken for execution, and log the result.
 */
@Aspect
@Component
public class ExecutionTimeAspect {

    /**
     * Advice that wraps the execution of all methods in the `com.aop.service` package.
     * Measures and logs the execution time of the intercepted method.
     * 
     * @param joinPoint provides access to the method being intercepted.
     * @return the result of the intercepted method's execution.
     * @throws Throwable if the intercepted method throws an exception.
     */
    @Around("execution(* com.aop.service.*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // Record the start time
        long start = System.currentTimeMillis();
        
        // Proceed with the execution of the intercepted method
        Object result = joinPoint.proceed();
        
        // Calculate the execution time
        long executionTime = System.currentTimeMillis() - start;
        
        // Log the execution time
        System.out.println("ExecutionTimeAspect: Method executed in " + executionTime + " ms");
        
        // Return the result of the method execution
        return result;
    }
}
