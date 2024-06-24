package com.study.rafael.curso_rest_spring.controllers;

import com.study.rafael.curso_rest_spring.dto.v1.User.AddRolesForUserDTO;
import com.study.rafael.curso_rest_spring.entities.PermissionEntity;
import com.study.rafael.curso_rest_spring.entities.UserEntity;
import com.study.rafael.curso_rest_spring.exceptions.ResourceNotFoundException;
import com.study.rafael.curso_rest_spring.repositories.PermissionRepository;
import com.study.rafael.curso_rest_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PermissionRepository permissionRepository;

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll() {
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @PostMapping("create-roles-for-user")
    public ResponseEntity<?> createRolesForUser(@RequestBody AddRolesForUserDTO data) {
        UserEntity user = this.userRepository.findById(data.getUserId()).orElseThrow(() -> new UsernameNotFoundException("Usuário nao encontrado"));
        PermissionEntity permission = this.permissionRepository.findById(data.getPermissionId()).orElseThrow(() -> new ResourceNotFoundException("Permissao nao encontrada"));

        user.addPermission(permission);

        this.userRepository.save(user);

        return ResponseEntity.ok(user);
    }
}
