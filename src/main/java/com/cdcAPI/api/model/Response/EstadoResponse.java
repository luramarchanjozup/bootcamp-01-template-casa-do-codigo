package com.cdcAPI.api.model.Response;

import com.cdcAPI.model.Estado;
import com.cdcAPI.model.Pais;

//Complexidade = 2
//Estado, País

public class EstadoResponse {

    private String nome;
    private Pais pais;

    public EstadoResponse (Estado estado) {
        nome = estado.getNome();
        pais = estado.getPais();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
