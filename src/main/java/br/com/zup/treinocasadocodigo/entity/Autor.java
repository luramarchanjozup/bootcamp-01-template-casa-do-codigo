package br.com.zup.treinocasadocodigo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String nome;
    private String descricao;

    protected Autor(){}

    public Autor(String email, String nome, String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }
    @Override
    public String toString() {
        return String.format(
                "{" +
                        "\"id\": \"%d\", " +
                        "\"email\": \"%s\", " +
                        "\"nome\": \"%s\", " +
                        "\"descricao\": \"%s\"" +
                "}",
                id, email, nome, descricao);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
