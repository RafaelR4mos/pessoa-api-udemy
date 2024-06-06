package com.study.rafael.curso_rest_spring.repositories;

import com.study.rafael.curso_rest_spring.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
