package com.study.rafael.curso_rest_spring.services;

import com.study.rafael.curso_rest_spring.entities.PersonEntity;
import com.study.rafael.curso_rest_spring.exceptions.ResourceNotFoundException;
import com.study.rafael.curso_rest_spring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepository;

    public List<PersonEntity> findAll() {
        return personRepository.findAll();
    }

    public PersonEntity findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }

    public PersonEntity create(PersonEntity person) {
        return personRepository.save(person);
    }

    public PersonEntity update(PersonEntity person) {
       PersonEntity personFound = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

       personFound.setFirstName(person.getFirstName());
       personFound.setLastName(person.getLastName());
       personFound.setAddress(person.getAddress());
       personFound.setGender(person.getGender());

       return personRepository.save(personFound);
    }

    public void delete(Long id) {
        PersonEntity entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        personRepository.delete(entity);
    }
}
