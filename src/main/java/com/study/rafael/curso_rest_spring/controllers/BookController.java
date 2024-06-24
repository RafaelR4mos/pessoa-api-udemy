package com.study.rafael.curso_rest_spring.controllers;

import com.study.rafael.curso_rest_spring.dto.v1.Book.BookCreateDTO;
import com.study.rafael.curso_rest_spring.dto.v1.Book.BookDTO;
import com.study.rafael.curso_rest_spring.exceptions.ErrorValidation;
import com.study.rafael.curso_rest_spring.exceptions.ExceptionResponse;
import com.study.rafael.curso_rest_spring.services.BookServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@Tag(name = "Book", description = "Endpoints for managing books")
public class BookController {

    private final BookServices bookServices;

    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Finds all books", description = "Finds all book in JSON or XML format", responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(
                            array = @ArraySchema(schema = @Schema(implementation = BookDTO.class))
                    )
            }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public List<BookDTO> findAll() {
        return this.bookServices.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Finds a book", description = "Find a specific book by id via URL Parameter.", responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(
                           schema = @Schema(implementation = BookDTO.class)
                    )
            }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = {
                    @Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )
            }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public BookDTO findById(@PathVariable Long id) {
        return this.bookServices.findById(id);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Creates a book", description = "Creates a book via JSON or XML format", responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(
                            schema = @Schema(implementation = BookDTO.class)
                    )
            }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = {
                    @Content(
                            schema = @Schema(implementation = ErrorValidation.class)
                    )
            }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public BookDTO create(@RequestBody @Valid BookCreateDTO bookCreateDTO) {
        return this.bookServices.create(bookCreateDTO);
    }

    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Updates a book properties", description = "Updates a book properties via JSON or XML", responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(
                            schema = @Schema(implementation = BookDTO.class)
                    )
            }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = {
                    @Content(
                            schema = @Schema(implementation = ErrorValidation.class)
                    )
            }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = {
                    @Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )
            }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public BookDTO update(@RequestBody @Valid BookCreateDTO bookCreateDTO, @PathVariable Long id) {
        return this.bookServices.update(bookCreateDTO, id);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletes a book", description = "Deletes a book via URL parameter {id}.", responses = {
            @ApiResponse(description = "No content",  responseCode = "204", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = {
                    @Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )
            }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        this.bookServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
