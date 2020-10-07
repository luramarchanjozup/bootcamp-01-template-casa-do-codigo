package br.com.ecommerce.cdc.domain.response;

import br.com.ecommerce.cdc.domain.model.Pais;

public class PaisResponse {

    private Long id;
    private String nome;

    public PaisResponse(){

    }

    public PaisResponse(Pais pais){
        this.id = pais.getId();
        this.nome = pais.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
