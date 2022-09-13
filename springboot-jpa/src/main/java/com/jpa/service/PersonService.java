package com.jpa.service;

import com.jpa.entity.Person;
import com.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person savePerson(Person person){
        return personRepository.save(person);
    }

    public List<Person> savePersons(List<Person> persons){
        return personRepository.saveAll(persons);
    }

    public List<Person> getPerson(){
        return personRepository.findAll();
    }

    public Person getPersonById(Long id){
        return personRepository.findById(id).orElse(null);
    }

    /*public Person getPersonByFirstName(String firstName){
        return personRepository.findByName(id).orElse(null);
    } 14.04 in java techie*/

    public String deleteProduct(Long id){
        personRepository.deleteById(id);
        return "Person Deleted "+id;
    }

    public Person updateProduct(Person person){
        Person exisiting= personRepository.findById(person.getId()).orElse(null);
        exisiting.setFirstName(person.getFirstName());
        exisiting.setLastName(person.getLastName());
        return personRepository.save(exisiting);
    }


}
