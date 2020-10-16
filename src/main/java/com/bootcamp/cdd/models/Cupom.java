package com.bootcamp.cdd.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Cupom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "O codigo precisa ser preenchido")
    private String codigo;
    @NotNull(message = "A porcentagem precisa ser preenchida") @Positive(message = "O valor precisa ser positivo")
    private BigDecimal porcentagem;
    @Future(message = "a data precisa ser no futuro")
    private LocalDate dataValidade;

    public Cupom(String codigo, BigDecimal porcentagem, LocalDate dataValidade) {
        this.codigo = codigo;
        this.porcentagem = porcentagem;
        this.dataValidade = dataValidade;
    }

    public Cupom() {
    }

    public long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getPorcentagem() {
        return porcentagem;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }
}
