package com.study.rafael.curso_rest_spring.repositories;

import com.study.rafael.curso_rest_spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User WHERE u.username =: userName")
    User findByUsername(@Param("username") String userName);
}
