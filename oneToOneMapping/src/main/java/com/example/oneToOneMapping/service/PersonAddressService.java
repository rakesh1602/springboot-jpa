package com.example.oneToOneMapping.service;

import com.example.oneToOneMapping.entity.AddressEntity;
import com.example.oneToOneMapping.entity.PersonEntity;
import com.example.oneToOneMapping.mapper.PersonAddressMapper;
import com.example.oneToOneMapping.model.Address;
import com.example.oneToOneMapping.model.Person;
import com.example.oneToOneMapping.repository.PersonRepository;
import com.example.oneToOneMapping.response.PersonResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class PersonAddressService {

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private  final PersonAddressMapper personAddressMapper;

    public PersonAddressService(PersonRepository personRepository, PersonAddressMapper personAddressMapper) {
        this.personRepository = personRepository;
        this.personAddressMapper = personAddressMapper;
    }


    public PersonResponse createPerson(Person person) {
        PersonEntity personEntity= null;
        personEntity= personAddressMapper.personToEntity(person);

        AddressEntity addressEntity=null;
        addressEntity= personAddressMapper.personToEntity(new Address());

        personRepository.save(personEntity);
        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(personEntity.getId());

        return personResponse;
    }

    public Person getPerson(Long id) {
        Person person=new Person();
        PersonEntity personEntity=personRepository.findById(id).orElse(null);
        if(personEntity!=null){
            person=personAddressMapper.entityToPerson(personEntity);
        } else {
            log.info("No such id found");
        }
        return person;

    }

    public void deletePerson(Long id) {
        Optional<PersonEntity> peopleEntityOptional = personRepository.findById(id);
        if (peopleEntityOptional.isPresent()) {
            personRepository.deleteById(id);
        } else {
            log.info("Person id " + id+ "Not found");
        }

    }


    public Person updatePerson(Long id, Person person) {
        PersonEntity personEntity=new PersonEntity();
        Optional<PersonEntity> optionalPersonEntity=personRepository.findById(id);
        if(optionalPersonEntity.isPresent()){

            /*personEntity.setFirstName(person.getFirstName());
            personEntity.setLastName(person.getLastName());*/
            personAddressMapper.personToEntity(person);
            personRepository.save(personEntity);
            log.info("Updated");
        } else {
            log.info("Person id " + id+ "Not found");
        }
        return person;
    }
}
