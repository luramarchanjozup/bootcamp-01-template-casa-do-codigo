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

    //Usar manager para puxar e validar criação de estado
    public Estado toModel(EntityManager manager) throws Exception {

        @NotBlank
        Pais pais = manager.find(Pais.class, paisId);

        if (pais == null) {
            throw new Exception("Estado não pode ser cadastrado. País não encontrado.");
        }
        return new Estado(nome, paisId);
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
