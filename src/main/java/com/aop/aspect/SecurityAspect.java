package com.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import com.aop.annotations.Secure;

/**
 * Aspect to enforce security based on roles defined in the `@Secure` annotation.
 * 
 * This aspect intercepts methods annotated with `@Secure` and checks if the current user
 * has the required role before proceeding with the method execution.
 */
@Aspect
@Component
public class SecurityAspect {

    /**
     * Around advice that intercepts methods annotated with `@Secure`.
     * Checks the user's role against the required role specified in the annotation.
     * 
     * @param joinPoint provides access to the method being intercepted.
     * @param secure the `@Secure` annotation applied on the method.
     * @return the result of the intercepted method's execution if the security check passes.
     * @throws Throwable if the security check fails or the intercepted method throws an exception.
     */
    @Around("@annotation(secure)")
    public Object checkSecurity(ProceedingJoinPoint joinPoint, Secure secure) throws Throwable {
        // Retrieve the required role from the `@Secure` annotation
        String requiredRole = secure.role();
        System.out.println("SecurityAspect: Required role for access: " + requiredRole);

        // Simulated user role - Replace this logic with a real user authentication/authorization mechanism
        String userRole = "ADMIN"; // Assume the user role is ADMIN for demonstration
        
        // Check if the user role matches the required role
        if (!userRole.equals(requiredRole)) {
            // Throw a security exception if the roles do not match
            throw new SecurityException("Unauthorized access: Required role is " + requiredRole);
        }

        // Proceed with the method execution if the role check passes
        return joinPoint.proceed();
    }
}
