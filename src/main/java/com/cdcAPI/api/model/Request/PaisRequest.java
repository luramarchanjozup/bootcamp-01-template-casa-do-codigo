package com.cdcAPI.api.model.Request;

import com.cdcAPI.model.Pais;
import com.cdcAPI.validator.EntradaUnica;

import javax.validation.constraints.NotBlank;

//Complexidade = 2
//EntradaUnica, Pais

public class PaisRequest {

    @NotBlank
    @EntradaUnica(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public PaisRequest() {

    } //Pediu default

    public PaisRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
