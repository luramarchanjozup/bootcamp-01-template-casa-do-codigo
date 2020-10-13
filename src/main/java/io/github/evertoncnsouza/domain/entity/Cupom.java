package io.github.evertoncnsouza.domain.entity;

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
    private Long id;

    @NotBlank
    private String codigo;

    @Positive
    @NotNull BigDecimal percentualDesconto;

    @Future
    @NotNull
    LocalDate validade;


    @Deprecated
    public Cupom() {
    }

    public Cupom(@NotBlank String codigo, @Positive @NotNull BigDecimal percentualDesconto,
                 @Future @NotNull LocalDate validade) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
        this.validade = validade;
    }


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", percentualDesconto=" + percentualDesconto +
                ", validade=" + validade +
                '}';
    }

    public boolean valido() {
        return LocalDate.now().compareTo(this.validade) <= 0; //Método para CupomValidoValidator;
    }

   public BigDecimal getPercentualDesconto() { //Get para CupomAplicado
        return percentualDesconto;
    }

    public LocalDate getValidade() {
        return validade; //Get para CupomAplicado
    }
}
