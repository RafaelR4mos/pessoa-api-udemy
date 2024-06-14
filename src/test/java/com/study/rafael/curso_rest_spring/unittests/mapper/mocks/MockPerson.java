package com.study.rafael.curso_rest_spring.unittests.mapper.mocks;

import com.study.rafael.curso_rest_spring.dto.v1.Person.PersonDTO;
import com.study.rafael.curso_rest_spring.entities.PersonEntity;
import com.study.rafael.curso_rest_spring.enums.Gender;

import java.util.ArrayList;
import java.util.List;



public class MockPerson {


    public PersonEntity mockEntity() {
        return mockEntity(0);
    }
    
    public PersonDTO mockVO() {
        return mockDTO(0);
    }
    
    public List<PersonEntity> mockEntityList() {
        List<PersonEntity> persons = new ArrayList<PersonEntity>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonDTO> mockVOList() {
        List<PersonDTO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTO(i));
        }
        return persons;
    }
    
    public PersonEntity mockEntity(Integer number) {
        PersonEntity person = new PersonEntity();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? Gender.MALE : Gender.FEMALE);
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public PersonDTO mockDTO(Integer number) {
        PersonDTO person = new PersonDTO();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? Gender.MALE : Gender.FEMALE);
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

}
