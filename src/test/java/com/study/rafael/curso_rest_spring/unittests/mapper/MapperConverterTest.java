package com.study.rafael.curso_rest_spring.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.study.rafael.curso_rest_spring.dto.v1.Person.PersonDTO;
import com.study.rafael.curso_rest_spring.entities.PersonEntity;
import com.study.rafael.curso_rest_spring.enums.Gender;
import com.study.rafael.curso_rest_spring.mapper.Mapper;
import com.study.rafael.curso_rest_spring.unittests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MapperConverterTest {
    
    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToDTOTest() {
        PersonDTO output = Mapper.parseObject(inputObject.mockEntity(0), PersonDTO.class);
        assertEquals(null, output.getId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals(Gender.MALE, output.getGender());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<PersonDTO> outputList = Mapper.parseListObjects(inputObject.mockEntityList(), PersonDTO.class);
        PersonDTO outputZero = outputList.get(0);
        
        assertEquals(null, outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals(Gender.MALE, outputZero.getGender());

        PersonDTO outputSeven = outputList.get(7);
        
        assertEquals(null, outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAddress());
        assertEquals(Gender.FEMALE, outputSeven.getGender());

        PersonDTO outputTwelve = outputList.get(12);
        
        assertEquals(null, outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAddress());
        assertEquals(Gender.MALE, outputTwelve.getGender());
    }

    @Test
    public void parseDTOToEntityTest() {
        PersonEntity output = Mapper.parseObject(inputObject.mockDTO(0), PersonEntity.class);
        assertEquals(0, output.getId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals(Gender.MALE, output.getGender());
    }

    @Test
    public void parseDTOListToEntityListTest() {
        List<PersonEntity> outputList = Mapper.parseListObjects(inputObject.mockDTOList(), PersonEntity.class);
        PersonEntity outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals(Gender.MALE, outputZero.getGender());

        PersonEntity outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAddress());
        assertEquals(Gender.FEMALE, outputSeven.getGender());

        PersonEntity outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAddress());
        assertEquals(Gender.MALE, outputTwelve.getGender());
    }
}
