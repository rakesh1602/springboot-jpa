package com.example.employeeMapStruct.model;

import com.example.employeeMapStruct.enitity.EmployeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ForMapping {
    ForMapping INSTANCE= Mappers.getMapper(ForMapping.class);

    @Mapping(source = "empAge", target = "age")


    Employee empToEmpEntity (EmployeEntity employeEntity);
    EmployeEntity empEntityTOEmp(EmployeEntity employee);


}
