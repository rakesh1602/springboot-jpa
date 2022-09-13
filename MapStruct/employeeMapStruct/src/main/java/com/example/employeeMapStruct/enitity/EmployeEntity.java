package com.example.employeeMapStruct.enitity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeEntity {
    private int id;
    private String firstName;
    private String lastName;
    private int empAge;


    public EmployeEntity() {

    }
}
