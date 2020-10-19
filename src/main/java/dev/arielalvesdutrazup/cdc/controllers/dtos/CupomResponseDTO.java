package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.Cupom;

import java.time.OffsetDateTime;

// 1 Cupom.java

public class CupomResponseDTO {

    private Long id;
    private String codigo;
    private OffsetDateTime validade;
    private Integer percentualDeDesconto;

    public CupomResponseDTO() {
    }

    public CupomResponseDTO(Cupom cupom) {
        setId(cupom.getId());
        setCodigo(cupom.getCodigo());
        setValidade(cupom.getValidade());
        setPercentualDeDesconto(cupom.getPercentualDeDesconto());
    }

    public Long getId() {
        return id;
    }

    public CupomResponseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public CupomResponseDTO setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public OffsetDateTime getValidade() {
        return validade;
    }

    public CupomResponseDTO setValidade(OffsetDateTime validade) {
        this.validade = validade;
        return this;
    }

    public Integer getPercentualDeDesconto() {
        return percentualDeDesconto;
    }

    public CupomResponseDTO setPercentualDeDesconto(Integer percentualDeDesconto) {
        this.percentualDeDesconto = percentualDeDesconto;
        return this;
    }
}
