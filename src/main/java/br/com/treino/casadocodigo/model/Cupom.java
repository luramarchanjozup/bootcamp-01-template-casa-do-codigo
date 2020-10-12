package br.com.treino.casadocodigo.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String codigo;
    private @NotNull @Positive BigDecimal percentualDesconto;
    private @NotNull @Future LocalDate validade;

    @Deprecated
    public Cupom(){}

    public Cupom(@NotBlank String codigo, @Positive BigDecimal percentualDesconto,
                 @Future LocalDate validade) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
        this.validade = validade;
    }

    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getCodigo() { return codigo; }

    public void setPercentualDesconto(BigDecimal percentualDesconto) {
        this.percentualDesconto = percentualDesconto; }

    public BigDecimal getPercentualDesconto() { return percentualDesconto; }

    public void setValidade(LocalDate validade) { this.validade = validade; }

    public LocalDate getValidade() { return validade; }

    public Boolean cupomValido(){
        return LocalDate.now().compareTo(this.validade) <= 0;
    }

}
