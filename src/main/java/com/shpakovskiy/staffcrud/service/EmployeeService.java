package com.shpakovskiy.staffcrud.service;

import com.shpakovskiy.staffcrud.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();
    Optional<Employee> findById(int theId);
    void save(Employee theEmployee);
    void deleteById(int theId);
}
