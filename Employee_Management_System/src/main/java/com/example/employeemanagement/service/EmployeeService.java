package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Service class handling business logic and in-memory employee storage.
 */
@Service
public class EmployeeService {

    private final Map<Long, Employee> employeeMap = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(103);

    public EmployeeService() {
        // Pre-populate with sample employees for testing right after startup
        employeeMap.put(101L, new Employee(101L, "Amit Sharma", "Engineering", 75000.0));
        employeeMap.put(102L, new Employee(102L, "Priya Patel", "Human Resources", 60000.0));
        employeeMap.put(103L, new Employee(103L, "Rahul Verma", "Finance", 68000.0));
    }

    /**
     * Operation (c): Retrieve all employees
     */
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    /**
     * Operation (c): Retrieve employee by ID
     */
    public Optional<Employee> getEmployeeById(Long id) {
        return Optional.ofNullable(employeeMap.get(id));
    }

    /**
     * Operation (b): Add a new employee
     */
    public Employee addEmployee(Employee employee) {
        if (employee.getId() == null || employee.getId() <= 0) {
            employee.setId(idCounter.incrementAndGet());
        }
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    /**
     * Operation (d): Update an employee's details
     */
    public Optional<Employee> updateEmployee(Long id, Employee employeeDetails) {
        if (!employeeMap.containsKey(id)) {
            return Optional.empty();
        }

        Employee existing = employeeMap.get(id);
        if (employeeDetails.getName() != null && !employeeDetails.getName().trim().isEmpty()) {
            existing.setName(employeeDetails.getName());
        }
        if (employeeDetails.getDepartment() != null && !employeeDetails.getDepartment().trim().isEmpty()) {
            existing.setDepartment(employeeDetails.getDepartment());
        }
        if (employeeDetails.getSalary() != null && employeeDetails.getSalary() > 0) {
            existing.setSalary(employeeDetails.getSalary());
        }

        employeeMap.put(id, existing);
        return Optional.of(existing);
    }

    /**
     * Operation (e): Delete an employee by ID
     */
    public boolean deleteEmployee(Long id) {
        return employeeMap.remove(id) != null;
    }
}
