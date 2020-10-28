package com.apicasadocodigo.casadocodigo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    @NotNull
    @NotEmpty
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @NotEmpty
    private String cpfOrcnpj;

    @NotNull
    @Embedded
    private Address address;

    @Deprecated
    public Client(){
    }

    @Deprecated
    public Client(Long id, @Email String email, @NotNull @NotEmpty String name, String lastName, @NotNull @NotEmpty String cpfOrcnpj,
                  @NotNull Address address) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.cpfOrcnpj = cpfOrcnpj;
        this.address = address;
    }

    public Client(@Email String email, @NotNull @NotEmpty String name, String lastName,
                  @NotNull @NotEmpty String cpfOrcnpj, @NotNull @NotEmpty Address address) {

        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.cpfOrcnpj = cpfOrcnpj;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCpfOrcnpj() { return cpfOrcnpj; }

    public Address getAddress() {
        return address;
    }

    @JsonIgnore
    public Long getCityId() {
        return address.getCityId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client that = (Client) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
