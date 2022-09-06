package com.example.newdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data @AllArgsConstructor @ToString
public class EmployeeEntity {
    private int id;
    private String firstName;
    private  String lastName;
}
