package com.study.rafael.curso_rest_spring.dto.v1.Book;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class BookCreateDTO {

    @NotNull(message = "O título é obrigatório.")
    @Size(min = 1, max = 200, message = "O título deve ter no mínimo 1 e no máximo 200 caracteres")
    @Schema(description = "Título do livro", example = "O pequeno príncipe")
    private String title;

    @NotNull(message = "O autor é obrigatório.")
    @Size(min = 1, max = 200, message = "O autor deve ter no mínimo 1 e no máximo 200 caracteres")
    private String author;

    @NotNull(message = "a editora é obrigatória.")
    @Size(min = 1, max = 200, message = "A editora deve ter no mínimo 2 e no máximo 200 caracteres")
    private String publisher;

    @NotNull(message = "O isbn é obrigatório.")
    @Size(min = 10, max = 20, message = "O isbn deve ter no mínimo 10 e no máximo 20 caracteres")
    private String isbn;

    @NotNull(message = "O preço é obrigatório.")
    @PositiveOrZero(message = "O preço deve ser maior ou igual a zero.")
    private Double price;

    public BookCreateDTO() {}

    public BookCreateDTO(String title, String author, String publisher, String isbn, Double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
