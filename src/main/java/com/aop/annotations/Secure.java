package com.aop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // Can be applied to methods only
@Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
public @interface Secure {
    String role() default "USER"; // Defines the required role for the method
}
