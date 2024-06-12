package com.study.rafael.curso_rest_spring.controllers;

import com.study.rafael.curso_rest_spring.dto.v1.PersonDTO;
import com.study.rafael.curso_rest_spring.dto.v2.PersonDTOV2;
import com.study.rafael.curso_rest_spring.entities.PersonEntity;
import com.study.rafael.curso_rest_spring.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    PersonServices personServices;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<PersonDTO> findAll() {
        return this.personServices.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonDTO findById(@PathVariable Long id) {
        return this.personServices.findById(id);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonDTO create(@RequestBody PersonDTO person) {
        return this.personServices.create(person);
    }

    // EXEMPLO de endpoint versionado /v2
    //  @PostMapping(value = "/v2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //    public PersonDTOV2 createV2(@RequestBody PersonDTOV2 person) {
    //    return this.personServices.createV2(person);
    //  }

    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonDTO update(@RequestBody PersonDTO person) {
        return this.personServices.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.personServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
