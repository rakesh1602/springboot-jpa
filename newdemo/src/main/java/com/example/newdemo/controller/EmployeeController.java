package com.example.newdemo.controller;

import com.example.newdemo.entity.EmployeeEntity;
import com.example.newdemo.model.Employee;
import com.example.newdemo.model.EmployeeResponse;
import com.example.newdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    private Employee employee;

    @GetMapping(path = "/employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable Long employeeId) {
        EmployeeEntity employeeEntity = employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }

    @PostMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody Employee employee) {
        EmployeeResponse employeeResponse = employeeService.createEmployee(employee);
        return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.OK);
    }

    @PutMapping(path = "/employees/{employeeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) {
        Employee empUpdate = employeeService.updateEmployee(employeeId, employee);
        return new ResponseEntity<>(empUpdate, HttpStatus.OK);
    }

    @DeleteMapping(path = "/employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeEntity> deleteEmployee(@PathVariable Long employeeId){
        EmployeeEntity empDelete =employeeService.deleteEmployee(employeeId);
        return  new ResponseEntity<>(empDelete, HttpStatus.OK);
    }
}

