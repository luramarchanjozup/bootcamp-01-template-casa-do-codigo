package com.cdcAPI.api.model.Response;

import com.cdcAPI.model.Estado;

//Complexidade = 1?
//Estado

public class EstadoResponse {

    private String nome;
    private Long paisId;

    public EstadoResponse (Estado estado) {
        nome = estado.getNome();
        paisId = estado.getPaisId();
    }

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
