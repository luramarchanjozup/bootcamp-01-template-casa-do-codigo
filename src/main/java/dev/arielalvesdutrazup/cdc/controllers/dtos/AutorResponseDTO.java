package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.Autor;

import java.time.OffsetDateTime;
import java.util.Objects;

public class AutorResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private OffsetDateTime cadastradoEm;

    public AutorResponseDTO() {}

    public AutorResponseDTO(Autor autor) {
        setId(autor.getId());
        setNome(autor.getNome());
        setEmail(autor.getEmail());
        setDescricao(autor.getDescricao());
        setCadastradoEm(autor.getCadastradoEm());
    }

    public Long getId() {
        return id;
    }

    public AutorResponseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public AutorResponseDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AutorResponseDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public AutorResponseDTO setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public OffsetDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public AutorResponseDTO setCadastradoEm(OffsetDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutorResponseDTO that = (AutorResponseDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(email, that.email) &&
                Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, descricao);
    }
}
