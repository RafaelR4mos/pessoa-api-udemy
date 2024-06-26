package com.study.rafael.curso_rest_spring.dto.v1.User;

import com.study.rafael.curso_rest_spring.entities.UserRole;

public class RegisterDTO {

    private String login;
    private String password;

    RegisterDTO(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
