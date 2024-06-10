package com.study.rafael.curso_rest_spring.mapper.customMappers;

import com.study.rafael.curso_rest_spring.dto.v2.PersonDTOV2;
import com.study.rafael.curso_rest_spring.entities.PersonEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PersonMapper {

    public PersonDTOV2 convertEntityTODTO(PersonEntity person) {
        PersonDTOV2 dto = new PersonDTOV2();

        dto.setId(person.getId());
        dto.setAddress(person.getAddress());
        dto.setBirthDate(String.valueOf(new Date()));
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setGender(person.getGender());

        return dto;
    }

    public PersonEntity convertDtoTOEntity(PersonDTOV2 personDto) {
        PersonEntity entity = new PersonEntity();

        entity.setId(personDto.getId());
        entity.setAddress(personDto.getAddress());
        //entity.setBirthDay(new Date()); nao inserido, pois está sendo usado como exemplo. Nao será persistido no BD.
        entity.setFirstName(personDto.getFirstName());
        entity.setLastName(personDto.getLastName());
        entity.setGender(personDto.getGender());

        return entity;
    }
}
