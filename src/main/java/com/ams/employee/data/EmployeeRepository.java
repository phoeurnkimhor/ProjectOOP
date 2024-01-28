package com.ams.employee.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



import com.ams.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    Optional<Employee> findById(int id);
    List<Employee> findByNameContainingIgnoreCase(String name);
    List<Employee> findByStatus(String status);
    
}
