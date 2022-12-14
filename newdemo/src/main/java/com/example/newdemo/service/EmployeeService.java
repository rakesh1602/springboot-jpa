package com.example.newdemo.service;

import com.example.newdemo.entity.EmployeeEntity;
import com.example.newdemo.model.Employee;
import com.example.newdemo.model.EmployeeResponse;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Log4j2
@ToString
@AllArgsConstructor
public class EmployeeService {

    public List<EmployeeEntity> employeeEntityList;
    EmployeeEntity employeeEntity;

    public EmployeeService() {
        employeeEntityList = List.of
                (
                        new EmployeeEntity(101, "Rakesh", "Chavan"),
                        new EmployeeEntity(102, "Suhcit", "Khadtar"),
                        new EmployeeEntity(103, "Aditya", "Mhatre"),
                        new EmployeeEntity(104, "Raj", "Bokade"),
                        new EmployeeEntity(105, "Kunal", "Dinkar"),
                        new EmployeeEntity(106, "Uttam", "Thakrey"),
                        new EmployeeEntity(107, "Prem", "Patil"),
                        new EmployeeEntity(108, "Sanket", "Mishra")
                );
    }

    public EmployeeEntity getEmployee(Long employeeId) {
        EmployeeEntity empEntity = null;
        for (EmployeeEntity e : employeeEntityList) {
            if (e.getId() == employeeId) {
                empEntity = e;
                break;
            }
        }
        return empEntity;
    }

    public List<EmployeeEntity> getAllEmployee() {
        return employeeEntityList;
    }

    public EmployeeResponse createEmployee(Employee employee) {
        int id = new Random().nextInt();
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId((long) id);

        log.info("Employee Name is {} {}", employee.getFirstName(), employee.getLastName());
        return employeeResponse;
    }

    public Employee updateEmployee(Long employeeId, Employee employee) {
        for (EmployeeEntity e : employeeEntityList) {
            if (employeeId == e.getId()) {
                e.setFirstName(employee.getFirstName());
                e.setLastName(employee.getLastName());
            }
        }
        log.info("Updated Employees are :  {} {}", employee.getFirstName(), employee.getLastName());

        return employee;
    }


    public void deleteEmployee(Long employeeId) {
        //employeeEntityList.stream().filter(t -> t.getId() == employeeId).collect(Collectors.toList());
        employeeEntityList.removeIf(t -> t.getId() == employeeId);
        log.info("Deleted");
    }
}







