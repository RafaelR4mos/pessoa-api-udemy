package com.study.rafael.curso_rest_spring.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "permission")
public class Permission implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERMISSION_SEQ")
    @SequenceGenerator(name = "PERMISSION_SEQ", sequenceName = "seq_permission", allocationSize = 1)
    private Long id;

    private String description;

    public Permission() {}

    @Override
    public String getAuthority() {
        return this.description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
