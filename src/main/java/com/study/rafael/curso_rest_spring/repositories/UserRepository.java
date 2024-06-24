package com.study.rafael.curso_rest_spring.repositories;

import com.study.rafael.curso_rest_spring.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    UserDetails findByLogin(String login);
}
