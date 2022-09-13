package com.example.mapStruct.mapStructdemo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class ProductDto {

    @Id
    private int id;
    private String name;
    private long Price;
}
