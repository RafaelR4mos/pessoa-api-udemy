package com.study.rafael.curso_rest_spring.unittests.services;

import com.study.rafael.curso_rest_spring.dto.v1.Person.PersonDTO;
import com.study.rafael.curso_rest_spring.entities.PersonEntity;
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
        assertEquals("Female", result.getGender());
    }

    /*@Test
    void testCreate() {
        //Cria entidade falsamente PERSISTIDA
        PersonEntity entity = input.mockEntity(1);

        PersonEntity persisted = entity;
        persisted.setId(1L);

        //Cria dados recebidos na request
        PersonDTO dto = input.mockDTO(1);
        dto.setId(1L);

        //Salva entity (SEM ID) retorna persistido (COM ID)
       when(repository.save(entity)).thenReturn(persisted);

        PersonDTO result = service.create(dto);

        //Assetions
        assertNotNull(result);
        assertNotNull(result.getId());

        assertEquals("Address Test2", result.getAddress());
        assertEquals("First Name Test2", result.getFirstName());
        assertEquals("Last Name Test2", result.getLastName());
        assertEquals("Male", result.getGender());
    }*/
}
