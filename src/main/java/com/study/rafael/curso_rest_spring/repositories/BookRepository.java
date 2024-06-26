package com.study.rafael.curso_rest_spring.repositories;

import com.study.rafael.curso_rest_spring.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
