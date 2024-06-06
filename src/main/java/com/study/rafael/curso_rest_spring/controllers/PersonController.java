package com.study.rafael.curso_rest_spring.controllers;

import com.study.rafael.curso_rest_spring.entities.PersonEntity;
import com.study.rafael.curso_rest_spring.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonServices personServices;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonEntity> findAll() {
        return this.personServices.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonEntity findById(@PathVariable Long id) {
        return this.personServices.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonEntity create(@RequestBody PersonEntity person) {
        return this.personServices.create(person);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonEntity update(@RequestBody PersonEntity person) {
        return this.personServices.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.personServices.delete(id);
    }
}
