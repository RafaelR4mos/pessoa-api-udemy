package com.study.rafael.curso_rest_spring.repositories;

import com.study.rafael.curso_rest_spring.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {
}
