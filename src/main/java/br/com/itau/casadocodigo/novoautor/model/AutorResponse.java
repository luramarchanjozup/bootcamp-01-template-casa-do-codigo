package br.com.itau.casadocodigo.novoautor.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class AutorResponse {

    private final Long id;
    private final String nome;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private final LocalDateTime horaCadastro;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getHoraCadastro() {
        return horaCadastro;
    }

    public AutorResponse(Autor autor){
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.horaCadastro = autor.getHoraCadastro();
    }
}
