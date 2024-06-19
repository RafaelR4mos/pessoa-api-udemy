package com.study.rafael.curso_rest_spring.unittests.services;

import com.study.rafael.curso_rest_spring.dto.v1.Book.BookCreateDTO;
import com.study.rafael.curso_rest_spring.dto.v1.Book.BookDTO;
import com.study.rafael.curso_rest_spring.dto.v1.Person.PersonDTO;
import com.study.rafael.curso_rest_spring.entities.BookEntity;
import com.study.rafael.curso_rest_spring.entities.PersonEntity;
import com.study.rafael.curso_rest_spring.exceptions.ResourceNotFoundException;
import com.study.rafael.curso_rest_spring.repositories.BookRepository;
import com.study.rafael.curso_rest_spring.services.BookServices;
import com.study.rafael.curso_rest_spring.unittests.mapper.mocks.MockBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class BookServicesTest {

    MockBook input;

    @InjectMocks
    private BookServices service;

    @Mock
    private BookRepository repository;

    @BeforeEach
    void setUpMocks() {
        input = new MockBook();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<BookEntity> entityList = input.mockEntityList(10);

        when(this.repository.findAll()).thenReturn(entityList);

        List<BookDTO> result = this.service.findAll();

        assertNotNull(result);
        assertEquals(10, result.size());

        BookDTO bookTwo = result.get(1);
        assertEquals("Title Test2", bookTwo.getTitle());
        assertEquals("Author Test2", bookTwo.getAuthor());
        assertEquals("Isbn Test2", bookTwo.getIsbn());
        assertEquals("Publisher Test2", bookTwo.getPublisher());
        assertEquals(2.0, bookTwo.getPrice());

        BookDTO bookThree = result.get(2);
        assertEquals("Title Test3", bookThree.getTitle());
        assertEquals("Author Test3", bookThree.getAuthor());
        assertEquals("Isbn Test3", bookThree.getIsbn());
        assertEquals("Publisher Test3", bookThree.getPublisher());
        assertEquals(3.0, bookThree.getPrice());

        BookDTO bookTen = result.get(9);
        assertEquals("Title Test10", bookTen.getTitle());
        assertEquals("Author Test10", bookTen.getAuthor());
        assertEquals("Isbn Test10", bookTen.getIsbn());
        assertEquals("Publisher Test10", bookTen.getPublisher());
        assertEquals(10.0, bookTen.getPrice());
    }

    @Test
    void testFindById() {
        BookEntity entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        // Chamar efetivamente o resultado
        BookDTO result = service.findById(1L);

        assertNotNull(result);
    }

    @Test
    void testCreate() {
        BookEntity entity = input.mockEntity(1);
        entity.setId(1L);

        when(this.repository.save(any(BookEntity.class))).thenReturn(entity);

        BookCreateDTO bookCreateDTO = input.mockCreateDTO(1);

        BookDTO result = this.service.create(bookCreateDTO);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Title Test1", result.getTitle());
        assertEquals("Author Test1", result.getAuthor());
        assertEquals("Isbn Test1", result.getIsbn());
        assertEquals("Publisher Test1", result.getPublisher());
        assertEquals(1.0, result.getPrice());
    }

    @Test
    void testUpdate() {
        BookEntity entity = input.mockEntity(1);
        entity.setId(1L);

        when(this.repository.findById(1L)).thenReturn(Optional.of(entity));
        when(this.repository.save(any(BookEntity.class))).thenReturn(entity);

        BookCreateDTO bookCreateDTO = input.mockCreateDTO(2);
        BookDTO result = this.service.update(bookCreateDTO, 1L);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Title Test2", result.getTitle());
        assertEquals("Author Test2", result.getAuthor());
        assertEquals("Isbn Test2", result.getIsbn());
        assertEquals("Publisher Test2", result.getPublisher());
        assertEquals(2.0, result.getPrice());
    }

    @Test
    void testDelete() {
        BookEntity entity = input.mockEntity(3);
        entity.setId(3L);

        when(this.repository.findById(3L)).thenReturn(Optional.of(entity));

        this.service.delete(entity.getId());
    }

    @Test
    void testFindByIdWithNonExistentBook() {
        assertThrows(ResourceNotFoundException.class, () -> {
            this.service.findById(1L);
        });
    }

    @Test
    void testUpdateWithNonExistentBook() {
        assertThrows(ResourceNotFoundException.class, () -> {
            BookCreateDTO bookCreateDTO = input.mockCreateDTO(1);
            this.service.update(bookCreateDTO, 1L);
        });
    }

    @Test
    void testDeleteWithNonExistentBook() {
        assertThrows(ResourceNotFoundException.class, () -> {
            this.service.delete(1L);
        });
    }
}
