package com.study.rafael.curso_rest_spring.services;

import com.study.rafael.curso_rest_spring.dto.v1.Person.PersonCreateDTO;
import com.study.rafael.curso_rest_spring.dto.v1.Person.PersonDTO;
import com.study.rafael.curso_rest_spring.dto.v2.PersonDTOV2;
import com.study.rafael.curso_rest_spring.entities.PersonEntity;
import com.study.rafael.curso_rest_spring.enums.Gender;
import com.study.rafael.curso_rest_spring.exceptions.RequiredObjectIsNullException;
import com.study.rafael.curso_rest_spring.exceptions.ResourceNotFoundException;
import com.study.rafael.curso_rest_spring.exceptions.handler.RegraDeNegocioException;
import com.study.rafael.curso_rest_spring.mapper.Mapper;
import com.study.rafael.curso_rest_spring.mapper.customMappers.PersonMapper;
import com.study.rafael.curso_rest_spring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;

    public List<PersonDTO> findAll() {

        return Mapper.parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        PersonEntity foundPerson = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        return Mapper.parseObject(foundPerson, PersonDTO.class);
    }

    public PersonDTO create(PersonCreateDTO personDTO) {
        if (personDTO == null) throw new RequiredObjectIsNullException();

        PersonEntity entity = Mapper.parseObject(personDTO, PersonEntity.class);

        return Mapper.parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 personDto) {

        PersonEntity entity = personMapper.convertDtoTOEntity(personDto);

        return personMapper.convertEntityTODTO(personRepository.save(entity));
    }

    public PersonDTO update(PersonDTO person) {
        if (person == null) throw new RequiredObjectIsNullException();

        PersonEntity personFound = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        personFound.setFirstName(person.getFirstName());
        personFound.setLastName(person.getLastName());
        personFound.setAddress(person.getAddress());
        personFound.setGender(person.getGender());

        return Mapper.parseObject(personRepository.save(personFound), PersonDTO.class);
    }

    public void delete(Long id) {
        PersonEntity entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        personRepository.delete(entity);
    }
}
