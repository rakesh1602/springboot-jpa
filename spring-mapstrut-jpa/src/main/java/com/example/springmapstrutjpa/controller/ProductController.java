package com.example.springmapstrutjpa.controller;

import com.example.springmapstrutjpa.dto.PersonDto;
import com.example.springmapstrutjpa.mapper.PersonMapper;
import com.example.springmapstrutjpa.model.Person;
import com.example.springmapstrutjpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/persons")
    public ResponseEntity<Person> save(@RequestBody PersonDto personDto){
        return new ResponseEntity<>(personRepository.save(
                personMapper.dtoToModel(personDto)), HttpStatus.CREATED);

    }

    @GetMapping("/persons")
    public ResponseEntity<List<PersonDto>> findall(){
        return new ResponseEntity<>(personMapper.modelsToDto(personRepository.findAll()),HttpStatus.OK);

    }

    @GetMapping("/persons/id")
    public ResponseEntity<PersonDto> findById(@PathVariable(value = "id")Long id){
        return new ResponseEntity<>(personMapper.modelToDto(personRepository.findById(id).get()),HttpStatus.OK);

    }

    @DeleteMapping("/persons/id")
    public ResponseEntity<PersonDto> deleteById(@PathVariable(value = "id")Long id){
        PersonDto personDto=personMapper.modelToDto(personRepository.findById(id).get());
        personRepository.deleteById(personDto.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
