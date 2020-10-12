package com.bootcamp.cdd.request;


public class ShoppingRequest {
    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    private Long estadoId;
    private long pais;
    private String telefone;
    private String cep;

    public ShoppingRequest(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long estadoId, long pais, String telefone, String cpf) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estadoId = estadoId;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getDocumento() {
        return documento;
    }
}
