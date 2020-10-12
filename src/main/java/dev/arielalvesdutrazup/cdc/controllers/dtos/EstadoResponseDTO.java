package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.Estado;

import java.time.OffsetDateTime;

public class EstadoResponseDTO {

    private Long id;
    private String nome;
    private String codigo;
    private OffsetDateTime cadastradoEm;
    private PaisResponseDTO pais;

    public EstadoResponseDTO() {
    }

    public EstadoResponseDTO(Estado estado) {
        setId(estado.getId());
        setNome(estado.getNome());
        setCodigo(estado.getCodigo());
        setPais(new PaisResponseDTO(estado.getPais()));
        setCadastradoEm(estado.getCadastradoEm());
    }

    public Long getId() {
        return id;
    }

    public EstadoResponseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public EstadoResponseDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public EstadoResponseDTO setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public OffsetDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public EstadoResponseDTO setCadastradoEm(OffsetDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
        return this;
    }

    public PaisResponseDTO getPais() {
        return pais;
    }

    public EstadoResponseDTO setPais(PaisResponseDTO pais) {
        this.pais = pais;
        return this;
    }
}
