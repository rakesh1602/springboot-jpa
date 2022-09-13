package com.example.employeeMapStruct.repository;

import com.example.employeeMapStruct.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {
}
