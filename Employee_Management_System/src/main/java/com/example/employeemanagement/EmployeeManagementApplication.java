package com.example.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Entry Point for Spring Boot Application.
 */
@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
        System.out.println("\n=======================================================");
        System.out.println(" Employee Management REST API is Running Successfully! ");
        System.out.println(" Local API Base URL : http://localhost:8081/api/employees ");
        System.out.println(" Chrome Frontend    : http://localhost:8081/index.html   ");
        System.out.println("=======================================================\n");
    }
}
