# SpringAOP-Examples

**A comprehensive guide to Aspect-Oriented Programming (AOP) in Spring Boot.** This repository showcases various AOP features such as logging, execution time measurement, and security enforcement using custom annotations. Perfect for developers looking to master AOP concepts and implement clean, modular, and maintainable code in their Spring Boot applications.

## Introduction

Aspect-Oriented Programming (AOP) complements Object-Oriented Programming (OOP) by allowing the separation of cross-cutting concerns such as logging, security, and transaction management. This repository provides practical examples of implementing AOP in Spring Boot, demonstrating how to enhance code modularity, readability, and maintainability.

---

## Features

- **Logging Aspect**
  - Logs method execution details before, after, and around method calls.
- **Execution Time Aspect**
  - Measures and logs the execution time of service methods.
- **Security Aspect**
  - Enforces role-based access control using custom annotations.
- **Custom Annotations**
  - `@Secure`: Specifies required roles for method execution.
- **Comprehensive Examples**
  - Demonstrates various AOP advices: `@Before`, `@After`, `@AfterReturning`, `@AfterThrowing`, and `@Around`.

---

## Technologies Used

- **Java 17**
- **Spring Boot 3.4.0**
- **Spring AOP**
- **Maven**
- **Spring Tool Suite (STS)**

---

## Project Structure

```plaintext
SpringAOP-Examples
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   ├── aop
│   │   │   │   │   ├── SpringAOPApplication.java
│   │   │   │   │   ├── aspect
│   │   │   │   │   │   ├── LoggingAspect.java
│   │   │   │   │   │   ├── ExecutionTimeAspect.java
│   │   │   │   │   │   └── SecurityAspect.java
│   │   │   │   │   ├── annotations
│   │   │   │   │   │   └── Secure.java
│   │   │   │   │   ├── service
│   │   │   │   │   │   └── MyService.java
│   │   │   │   │   └── runner
│   │   │   │   │       └── MyRunner.java
├── pom.xml
└── README.md


