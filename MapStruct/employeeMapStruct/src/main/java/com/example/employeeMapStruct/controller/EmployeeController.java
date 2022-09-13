package com.example.employeeMapStruct.controller;

import com.example.employeeMapStruct.enitity.EmployeEntity;
import com.example.employeeMapStruct.model.Employee;
import com.example.employeeMapStruct.model.ForMapping;
import com.example.employeeMapStruct.repository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @Component
public class EmployeeController {
    @Autowired
    private EmployeEntity employeEntity;
    @Autowired
    private Employee employee;
    @Autowired
    private ForMapping emplpyeeMapper;
    @Autowired
    private EmployeeRespository employeeRespository;

    @GetMapping(path = "/employees")
    public ResponseEntity<EmployeEntity> findAll(){
   return new ResponseEntity<>(emplpyeeMapper.empEntityTOEmp((EmployeEntity) employeeRespository.findAll()), HttpStatus.OK);

    }


}
