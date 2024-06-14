package com.study.rafael.curso_rest_spring.dto.v1.Person;

import com.study.rafael.curso_rest_spring.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

public class PersonCreateDTO {

    @NotNull(message = "O nome é obrigatório.")
    @Size(max = 80, message = "O nome nao deve ultrapassar 80 caracteres.")
    private String firstName;

    @NotNull(message = "O sobrenome é obrigatório.")
    @Size(max = 80, message = "O sobrenome nao deve ultrapassar 80 caracteres.")
    private String lastName;

    @NotNull(message = "O endereço é obrigatório.")
    @Size(max = 100, message = "O endereço nao deve ultrapassar 100 caracteres")
    private String address;

    @NotNull(message = "O genero é obrigatório.")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    public PersonCreateDTO( String firstName, String lastName, String address, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public PersonCreateDTO() {}

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
