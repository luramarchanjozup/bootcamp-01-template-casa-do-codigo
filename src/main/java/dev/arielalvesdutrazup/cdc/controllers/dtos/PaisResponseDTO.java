package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.Pais;

import java.time.OffsetDateTime;
import java.util.Objects;

// 1 Pais.java
public class PaisResponseDTO {

    private Long id;
    private String nome;
    private String codigo;
    private OffsetDateTime cadastradoEm;

    public PaisResponseDTO() {
    }

    public PaisResponseDTO(Pais pais) {
        setId(pais.getId());
        setNome(pais.getNome());
        setCodigo(pais.getCodigo());
        setCadastradoEm(pais.getCadastradoEm());
    }

    public Long getId() {
        return id;
    }

    public PaisResponseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public PaisResponseDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public PaisResponseDTO setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public OffsetDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public PaisResponseDTO setCadastradoEm(OffsetDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaisResponseDTO that = (PaisResponseDTO) o;

        return Objects.equals(id, that.id) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, codigo, cadastradoEm);
    }

    @Override
    public String toString() {
        return "PaisResponseDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cadastradoEm=" + cadastradoEm +
                '}';
    }
}
