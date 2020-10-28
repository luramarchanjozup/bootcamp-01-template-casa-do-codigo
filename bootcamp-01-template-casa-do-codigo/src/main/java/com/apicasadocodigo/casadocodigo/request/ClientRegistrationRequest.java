package com.apicasadocodigo.casadocodigo.request;

import com.apicasadocodigo.casadocodigo.model.Address;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClientRegistrationRequest {

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

    public ClientRegistrationRequest(@Email String email, @NotNull @NotEmpty String name, String lastName,
                                     @NotNull @NotEmpty String cpfOrcnpj, @NotNull Address address) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.cpfOrcnpj = cpfOrcnpj;
        this.address = address;
    }

    public ClientRegistrationRequest toModel(){
        return new ClientRegistrationRequest(email, name, lastName, cpfOrcnpj, address);
    }
}
