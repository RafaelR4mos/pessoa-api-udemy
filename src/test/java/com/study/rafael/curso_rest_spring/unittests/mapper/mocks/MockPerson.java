package com.study.rafael.curso_rest_spring.unittests.mapper.mocks;

import com.study.rafael.curso_rest_spring.dto.v1.PersonDTO;
import com.study.rafael.curso_rest_spring.entities.PersonEntity;

import java.util.ArrayList;
import java.util.List;



public class MockPerson {


    public PersonEntity mockEntity() {
        return mockEntity(0);
    }
    
    public PersonDTO mockVO() {
        return mockVO(0);
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
            persons.add(mockVO(i));
        }
        return persons;
    }
    
    public PersonEntity mockEntity(Integer number) {
        PersonEntity person = new PersonEntity();
        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public PersonDTO mockVO(Integer number) {
        PersonDTO person = new PersonDTO();
        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

}
