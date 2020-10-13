package com.cdcAPI.api.model.Request;

import com.cdcAPI.model.Estado;
import com.cdcAPI.model.Pais;
import com.cdcAPI.validator.EntradaUnica;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//Complexidade = 3
//EntradaUnica, pais, estado

public class EstadoRequest {

    @NotBlank
    @EntradaUnica(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    private Long paisId;

    public EstadoRequest(@NotBlank String nome, @NotNull Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    //2 estado
    public Estado toModel(EntityManager manager) throws Exception {

        //3 pais
        Pais pais = manager.find(Pais.class, paisId);

        return new Estado(nome, pais);
    }

    //get set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }
}
