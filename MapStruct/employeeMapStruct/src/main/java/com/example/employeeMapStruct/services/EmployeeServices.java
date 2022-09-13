package com.example.employeeMapStruct.services;

import com.example.employeeMapStruct.enitity.EmployeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {

    List<EmployeEntity> employeeList;

    public EmployeeServices() {
        employeeList = List.of(
                new EmployeEntity(101, "Rakesh", "Chavan", 23),
                new EmployeEntity(102, "Rohit", "Sharma", 33),
                new EmployeEntity(103, "Virat", "Kohli", 31),
                new EmployeEntity(104, "Ms", "Dhoni", 41),
                new EmployeEntity(105, "Jasprit", "Bhumrah", 29)
        );

    }
}
