package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.Categoria;

import java.time.OffsetDateTime;
import java.util.Objects;

public class CategoriaResponseDTO {

    private Long id;
    private String nome;
    private OffsetDateTime cadastradoEm;

    public CategoriaResponseDTO() {
    }

    public CategoriaResponseDTO(Categoria categoria) {
        setId(categoria.getId());
        setNome(categoria.getNome());
        setCadastradoEm(categoria.getCadastradoEm());
    }

    public Long getId() {
        return id;
    }

    public CategoriaResponseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaResponseDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public OffsetDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public CategoriaResponseDTO setCadastradoEm(OffsetDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaResponseDTO that = (CategoriaResponseDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
