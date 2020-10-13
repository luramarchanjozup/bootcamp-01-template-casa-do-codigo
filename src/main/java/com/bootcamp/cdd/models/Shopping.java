package com.bootcamp.cdd.models;

import javax.persistence.*;

@Entity
public class Shopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    @ManyToOne
    private State estado;
    @ManyToOne
    private Country pais;
    private String telefone;
    private String cep;

    public Shopping(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
    }

    public void setEstado(State estado) {
        this.estado = estado;
    }

    public void setPais(Country pais) {
        this.pais = pais;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public State getEstado() {
        return estado;
    }

    public Country getPais() {
        return pais;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
