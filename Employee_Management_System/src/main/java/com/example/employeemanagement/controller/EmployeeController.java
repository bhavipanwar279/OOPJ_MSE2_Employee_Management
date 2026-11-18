package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST Controller for Employee Management System.
 * Base Path: /api/employees
 */
@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*") // Allows web browser / Chrome frontend access
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // =========================================================================
    // Question 2 (b) - 2 Marks
    // Implement a REST endpoint to add a new employee using @PostMapping and @RequestBody.
    // HTTP Method: POST
    // URL: http://localhost:8080/api/employees
    // =========================================================================
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        // Returns 201 Created status with the saved employee
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // =========================================================================
    // Question 2 (c) Part 1 - 1 Mark
    // Retrieve all employees using @GetMapping.
    // HTTP Method: GET
    // URL: http://localhost:8080/api/employees
    // =========================================================================
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        // Returns 200 OK
        return ResponseEntity.ok(employees);
    }

    // =========================================================================
    // Question 2 (c) Part 2 - 1 Mark
    // Retrieve a specific employee by ID using @GetMapping.
    // HTTP Method: GET
    // URL: http://localhost:8080/api/employees/{id}
    // =========================================================================
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get()); // 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: Employee not found with ID: " + id); // 404 Not Found
        }
    }

    // =========================================================================
    // Question 2 (d) - 2 Marks
    // Implement an endpoint to update an employee's details using @PutMapping.
    // HTTP Method: PUT
    // URL: http://localhost:8080/api/employees/{id}
    // =========================================================================
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Optional<Employee> updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
        if (updatedEmployee.isPresent()) {
            return ResponseEntity.ok(updatedEmployee.get()); // 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: Cannot update. Employee not found with ID: " + id); // 404 Not Found
        }
    }

    // =========================================================================
    // Question 2 (e) - 2 Marks
    // Implement an endpoint to delete an employee by ID using @DeleteMapping.
    // Return appropriate HTTP responses for successful operations and when an employee is not found.
    // HTTP Method: DELETE
    // URL: http://localhost:8080/api/employees/{id}
    // =========================================================================
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        boolean deleted = employeeService.deleteEmployee(id);
        if (deleted) {
            return ResponseEntity.ok("Success: Employee with ID " + id + " was deleted successfully."); // 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: Cannot delete. Employee not found with ID: " + id); // 404 Not Found
        }
    }
}
