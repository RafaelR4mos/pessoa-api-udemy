package com.study.rafael.curso_rest_spring.dto.v1.Person;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.study.rafael.curso_rest_spring.enums.Gender;

//Muda a ordem em que as propriedades aparecem no JSON.
@JsonPropertyOrder({ "id", "firstName", "lastName",  "address", "gender" })
public class PersonDTO {

    private Long id;

    //@JsonProperty("nome") para mudar o nome da propriedade gerada.
    private String firstName;

    //@JsonProperty("sobrenome")
    private String lastName;


    private String address;

    //@JsonIgnore can hide the propery in JSON.
    private Gender gender;

    public PersonDTO(Long id, String firstName, String lastName, String address, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public PersonDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
