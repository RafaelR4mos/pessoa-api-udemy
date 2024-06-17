package com.study.rafael.curso_rest_spring.unittests.services;

import com.study.rafael.curso_rest_spring.dto.v1.Person.PersonCreateDTO;
import com.study.rafael.curso_rest_spring.dto.v1.Person.PersonDTO;
import com.study.rafael.curso_rest_spring.entities.PersonEntity;
import com.study.rafael.curso_rest_spring.enums.Gender;
import com.study.rafael.curso_rest_spring.exceptions.RequiredObjectIsNullException;
import com.study.rafael.curso_rest_spring.repositories.PersonRepository;
import com.study.rafael.curso_rest_spring.services.PersonServices;
import com.study.rafael.curso_rest_spring.unittests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServicesTest {

    MockPerson input;

    @InjectMocks
    private PersonServices service;

    @Mock
    PersonRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        //Seta o mock
        PersonEntity entity = input.mockEntity(1);
        entity.setId(1L);

        //Mockar resultado
        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        // Chamar efetivamente o resultado
        PersonDTO result = service.findById(1L);

        //Assertions
        assertNotNull(result);
        assertNotNull(result.getId());

        assertEquals("Address Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals(Gender.FEMALE, result.getGender());
    }

    @Test
    void testCreate() {
        PersonEntity persisted = input.mockEntity(2);
        persisted.setId(1L);

        when(this.repository.save(any(PersonEntity.class))).thenReturn(persisted);

        PersonCreateDTO personCreateDTO = input.mockCreateDTO(2);
        PersonDTO result = this.service.create(personCreateDTO);

        //Assetions
        assertNotNull(result);
        assertNotNull(result.getId());

        assertEquals("Address Test2", result.getAddress());
        assertEquals("First Name Test2", result.getFirstName());
        assertEquals("Last Name Test2", result.getLastName());
        assertEquals(Gender.MALE, result.getGender());
    }

    @Test
    void testUpdate() {
        PersonEntity entity = input.mockEntity(2);
        entity.setId(2L);

        when(this.repository.findById(2L)).thenReturn(Optional.of(entity));
        when(this.repository.save(any(PersonEntity.class))).thenReturn(entity);

        PersonDTO personCreateDTO = input.mockDTO(2);
        PersonDTO result = this.service.update(personCreateDTO);

        //Assetions
        assertNotNull(result);
        assertNotNull(result.getId());

        assertEquals("Address Test2", result.getAddress());
        assertEquals("First Name Test2", result.getFirstName());
        assertEquals("Last Name Test2", result.getLastName());
        assertEquals(Gender.MALE, result.getGender());
    }

    @Test
    void testDelete() {
        PersonEntity entity = input.mockEntity(1);
        entity.setId(1L);

        when(this.repository.findById(1L)).thenReturn(Optional.of(entity));


        this.service.delete(1L);
    }

    @Test
    void testCreateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
           this.service.create(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testUpdateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            this.service.update(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
