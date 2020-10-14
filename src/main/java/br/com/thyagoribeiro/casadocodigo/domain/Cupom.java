package br.com.thyagoribeiro.casadocodigo.domain;

import br.com.thyagoribeiro.casadocodigo.validator.Exist;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Date;

// CDD - Total 0

@Entity
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String codigo;

    @NotNull
    @Positive
    private Long percentual;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate validade;

    @Deprecated
    public Cupom() {
    }

    public Cupom(@NotNull String codigo, @NotNull @Positive Long percentual, @Future LocalDate validade) {
        this.codigo = codigo;
        this.percentual = percentual;
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

    public Long getPercentual() {
        return percentual;
    }

    public void setPercentual(Long percentual) {
        this.percentual = percentual;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
