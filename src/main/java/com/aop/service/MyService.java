package com.aop.service;

import org.springframework.stereotype.Service;

import com.aop.annotations.Secure;

/**
 * Service class that provides business logic and operations.
 * Demonstrates the use of AOP annotations for logging and securing specific methods.
 */
@Service
public class MyService {

    /**
     * Performs a general action. This method is accessible to all users
     * and does not require any special role for execution.
     * 
     * @param action the name of the action to be performed.
     */
    public void performAction(String action) {
        System.out.println("Performing action: " + action);
    }
    
    /**
     * Performs a secure action. This method is restricted to users with the "ADMIN" role.
     * The `@Secure` annotation ensures that only authorized users can execute this method.
     */
    @Secure(role = "ADMIN")
    public void performSecureAction() {
        System.out.println("MyService: Performing a secure action.");
    }
}
