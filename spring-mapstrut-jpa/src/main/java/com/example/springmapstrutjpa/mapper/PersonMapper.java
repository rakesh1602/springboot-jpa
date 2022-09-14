package com.example.springmapstrutjpa.mapper;

import com.example.springmapstrutjpa.dto.PersonDto;
import com.example.springmapstrutjpa.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE= Mappers.getMapper(PersonMapper.class);
    PersonDto modelToDto(Person person);
    Person dtoToModel(PersonDto personDto);

    List<PersonDto> modelsToDto(List<Person> person);
}
