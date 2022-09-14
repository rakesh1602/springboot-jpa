package com.example.springmapstrutjpa.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class PersonDto{

    @Id
    private long id;
    private String firstName;
    private String lastName;
}
