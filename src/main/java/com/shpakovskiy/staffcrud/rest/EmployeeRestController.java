package com.shpakovskiy.staffcrud.rest;

import com.shpakovskiy.staffcrud.entity.Employee;
import com.shpakovskiy.staffcrud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Optional<Employee> theEmployee = employeeService.findById(employeeId);

        if (!theEmployee.isPresent()) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee.get();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        employee.setId(0);
        employeeService.save(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeService.save(employee);

        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Optional<Employee> tempEmployee = employeeService.findById(employeeId);

        if (!tempEmployee.isPresent()) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }

}