package com.study.rafael.curso_rest_spring.dto.v1.Book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BookCreateDTO {

    @NotNull
    @Size(min = 1, max = 200, message = "O título deve ter no mínimo 1 e no máximo 200 caracteres")
    private String title;

    @NotNull
    @Size(min = 1, max = 200, message = "O autor deve ter no mínimo 1 e no máximo 200 caracteres")
    private String author;

    @NotNull
    @Size(min = 1, max = 200, message = "O autor deve ter no mínimo 2 e no máximo 200 caracteres")
    private String publisher;

    @NotNull
    @Size(min = 10, max = 20, message = "O isbn deve ter no mínimo 10 e no máximo 20 caracteres")
    private String isbn;

    @NotNull
    @Min(value = 0, message = "O preço não pode ser menor que zero")
    private Double price;

    public BookCreateDTO() {}

    public BookCreateDTO(String title, String author, String publisher, String isbn, Double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.price = price;
    }
}
