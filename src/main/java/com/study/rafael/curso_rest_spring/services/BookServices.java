package com.study.rafael.curso_rest_spring.services;

import com.study.rafael.curso_rest_spring.dto.v1.Book.BookCreateDTO;
import com.study.rafael.curso_rest_spring.dto.v1.Book.BookDTO;
import com.study.rafael.curso_rest_spring.entities.BookEntity;
import com.study.rafael.curso_rest_spring.exceptions.ResourceNotFoundException;
import com.study.rafael.curso_rest_spring.mapper.Mapper;
import com.study.rafael.curso_rest_spring.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> findAll() {
        return Mapper.parseListObjects(this.bookRepository.findAll(), BookDTO.class);
    }

    public BookDTO findById(Long id) {
        BookEntity entity = this.bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum livro encontrado com este id"));
        return Mapper.parseObject(entity, BookDTO.class);
    }

    public BookDTO create(BookCreateDTO bookCreateDTO) {

        BookEntity entity = Mapper.parseObject(bookCreateDTO, BookEntity.class);

        return Mapper.parseObject(this.bookRepository.save(entity), BookDTO.class);
    }

    public BookDTO update(BookCreateDTO bookCreateDTO, Long id) {
        BookEntity entity = this.bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livro para editar nao encontrado."));

        entity.setTitle(bookCreateDTO.getTitle());
        entity.setAuthor(bookCreateDTO.getAuthor());
        entity.setPublisher(bookCreateDTO.getPublisher());
        entity.setIsbn(bookCreateDTO.getIsbn());
        entity.setPrice(bookCreateDTO.getPrice());

        return Mapper.parseObject(this.bookRepository.save(entity), BookDTO.class);
    }

    public void delete(Long id) {
        BookEntity entity = this.bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livro para deletar nao encontrado"));

        this.bookRepository.delete(entity);
    }
}
