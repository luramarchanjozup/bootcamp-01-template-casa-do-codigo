package br.com.ecommerce.cdc.domain.response;

import br.com.ecommerce.cdc.domain.model.Estado;
import br.com.ecommerce.cdc.domain.model.Pais;

public class EstadoResponse {

    private Long id;
    private String nome;
    private Pais pais;

    public EstadoResponse() {
    }

    public EstadoResponse(Long id, String nome, Pais pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }

    public EstadoResponse(Estado estado){
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.pais = estado.getPais();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}
