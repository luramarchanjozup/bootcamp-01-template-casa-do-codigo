package com.bootcamp.cdd.request;


import com.bootcamp.cdd.models.Shopping;

public class ShoppingRequest {
    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    private Long estadoId;
    private long paisId;
    private String telefone;
    private String cep;

    public ShoppingRequest(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long estadoId, long paisId, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estadoId = estadoId;
        this.paisId = paisId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getDocumento() {
        return documento;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public long getPais() {
        return paisId;
    }

    public Shopping toModel () {
        return new Shopping(this.email, this.nome, this. sobrenome, this.documento, this.endereco, this.complemento, this.cidade, this.telefone, this.cep);
    }
}
