package com.study.rafael.curso_rest_spring.unittests.mapper.mocks;

import com.study.rafael.curso_rest_spring.dto.v1.Book.BookCreateDTO;
import com.study.rafael.curso_rest_spring.dto.v1.Book.BookDTO;
import com.study.rafael.curso_rest_spring.entities.BookEntity;

import java.util.ArrayList;
import java.util.List;

public class MockBook {

    public BookEntity mockEntity() {
        return mockEntity(0);
    }

    public BookDTO mockDTO() {
        return mockDTO(0);
    }

    public BookEntity mockEntity(Integer number) {
        BookEntity book = new BookEntity();
        book.setTitle("Title Test" + number);
        book.setAuthor("Author Test" + number);
        book.setPublisher("Publisher Test" + number);
        book.setIsbn("Isbn Test" + number);
        book.setPrice(0.0 + number);

        return book;
    }

    public BookDTO mockDTO(Integer number) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Title Test" + number);
        bookDTO.setAuthor("Author Test" + number);
        bookDTO.setPublisher("Publisher Test" + number);
        bookDTO.setIsbn("Isbn Test" + number);
        bookDTO.setPrice(0.0 + number);

        return bookDTO;
    }

    public BookCreateDTO mockCreateDTO(Integer number) {
        BookCreateDTO bookCreateDTO = new BookCreateDTO();
        bookCreateDTO.setTitle("Title Test" + number);
        bookCreateDTO.setAuthor("Author Test" + number);
        bookCreateDTO.setIsbn("Isbn Test" + number);
        bookCreateDTO.setPublisher("Publisher Test" + number);
        bookCreateDTO.setPrice(0.0 + number);

        return bookCreateDTO;
    }

    public List<BookEntity> mockEntityList(Integer itemsQuantity) {
        List<BookEntity> books = new ArrayList<>();
        for(int i = 0; i < itemsQuantity; i++) {
            books.add(mockEntity(i));
        }

        return books;
    }

    public List<BookDTO> mockDTOList(Integer itemsQuantity) {
        List<BookDTO> books = new ArrayList<>();
        for(int i = 0; i < itemsQuantity; i++) {
            books.add(mockDTO(i));
        }

        return books;
    }
}
