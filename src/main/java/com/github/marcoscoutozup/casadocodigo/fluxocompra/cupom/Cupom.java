package com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@NamedQuery(
        name="findCupomByCodigo",
        query="select c from Cupom c where codigo = :codigo"
)
public class Cupom {

    @Id
    @GeneratedValue(generator = "uuid4")
    private UUID id;

    @NotBlank
    private String codigo;

    @NotNull
    @Positive
    private Integer percentual;

    @Future
    private LocalDate validade;

    @Deprecated
    public Cupom() {
    }

    public Cupom(@NotBlank String codigo, @NotNull @Positive Integer percentual, @Future LocalDate validade) {
        this.codigo = codigo;
        this.percentual = percentual;
        this.validade = validade;
    }

    public UUID getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getPercentual() {
        return percentual;
    }

    public void setPercentual(Integer percentual) {
        this.percentual = percentual;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public boolean estaValido(){
        return validade == null || validade.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Cupom{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", percentual=" + percentual +
                ", validade=" + validade +
                '}';
    }
}
