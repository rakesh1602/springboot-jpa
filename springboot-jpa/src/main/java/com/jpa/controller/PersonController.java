package com.jpa.controller;

import com.jpa.entity.Person;
import com.jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/addPersons")
    public Person addPerson(@RequestBody Person person){
        return personService.savePerson(person);
    }

    @PostMapping("/addMorePersons")
    public List<Person> addPersons(@RequestBody List<Person> person){
        return personService.savePersons(person);
    }

    @GetMapping ("/persons")
    public  List<Person>  findAllPerson(){
        return  personService.getPerson();
    }

    @GetMapping ("/persons/{id}")
    public Person findPersonById(@PathVariable Long id){
        return  personService.getPersonById(id);
    }

}
