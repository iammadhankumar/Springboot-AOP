package com.aop.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.aop.service.MyService;

/**
 * Runner class that executes when the Spring Boot application starts.
 * 
 * It demonstrates how to invoke methods from `MyService` and showcases the
 * functionality of Aspect-Oriented Programming (AOP) features such as logging,
 * execution time measurement, and security.
 */
@Component
public class MyRunner implements CommandLineRunner {

    // Dependency injection of MyService to access its methods
    @Autowired
    private MyService myService;

    /**
     * Entry point for custom logic to be executed on application startup.
     * 
     * @param args command-line arguments (not used here).
     * @throws Exception if any error occurs during execution.
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyRunner: Starting application...");

        // Example of calling a standard service method
        myService.performAction("Sample Action");

        // Example of calling a secure service method
        // This method is intercepted by SecurityAspect if annotated with @Secure
        try {
            myService.performSecureAction();
        } catch (SecurityException e) {
            System.out.println("MyRunner: Security exception caught - " + e.getMessage());
        }

        System.out.println("MyRunner: Application execution completed.");
    }
}
