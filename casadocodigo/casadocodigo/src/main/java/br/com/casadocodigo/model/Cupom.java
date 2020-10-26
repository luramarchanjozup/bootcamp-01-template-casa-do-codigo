package br.com.casadocodigo.model;

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
    @NotNull
    private BigDecimal desconto;

    @Future
    @NotNull
    private LocalDate validade;

    @Deprecated
    public Cupom() {
    }

    public Cupom(@NotNull String codigo, @Positive @NotNull BigDecimal desconto,
                 @Future @NotNull LocalDate validade) {
        this.codigo = codigo;
        this.desconto = desconto;
        this.validade = validade;
    }

    public boolean valido() {
        return LocalDate.now().compareTo(this.validade) <= 0;
    }

    //GETT END SETT
}
