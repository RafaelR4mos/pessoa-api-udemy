package com.study.rafael.curso_rest_spring.controllers;

import com.study.rafael.curso_rest_spring.dto.v1.PersonDTO;
import com.study.rafael.curso_rest_spring.dto.v2.PersonDTOV2;
import com.study.rafael.curso_rest_spring.entities.PersonEntity;
import com.study.rafael.curso_rest_spring.services.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@Tag(name = "People", description = "Endpoints for managing people")
public class PersonController {

    @Autowired
    PersonServices personServices;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Finds all People", description = "Finsd all People", tags = {"People"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class))
                    )
            }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public List<PersonDTO> findAll() {
        return this.personServices.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Finds a Person", description = "Finds a Person", tags = {"People"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = PersonDTO.class))
            }),
            @ApiResponse(description = "No content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public PersonDTO findById(@PathVariable Long id) {
        return this.personServices.findById(id);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Create a Person via JSON or XML format", description = "Create a person via JSON or XML format", tags = {"People"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = PersonDTO.class))
            }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
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
    @Operation(summary = "Updates a Person via JSON or XML format", description = "Updates a person via JSON or XML format", tags = {"People"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = @Content),
            @ApiResponse(description = "No content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public PersonDTO update(@RequestBody PersonDTO person) {
        return this.personServices.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.personServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
