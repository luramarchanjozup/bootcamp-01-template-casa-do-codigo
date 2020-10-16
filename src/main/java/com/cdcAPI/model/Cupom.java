package com.cdcAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String codigo;

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private BigDecimal porcentagem;

    @NotNull
    @Future
    private LocalDate validade;

    @Deprecated
    public Cupom() {}

    public Cupom(@NotBlank String codigo, @NotNull @Min(value = 1) @Max(value = 100) BigDecimal porcentagem,
                 @NotNull @Future LocalDate validade) {

        this.codigo = codigo;
        this.porcentagem = porcentagem;
        this.validade = validade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(BigDecimal porcentagem) {
        this.porcentagem = porcentagem;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
