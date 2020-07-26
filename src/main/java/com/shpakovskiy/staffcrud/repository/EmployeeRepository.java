package com.shpakovskiy.staffcrud.repository;

import com.shpakovskiy.staffcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
