package br.com.ecommerce.cdc.domain.model;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
@Table(name = "cupom")
public class CupomDesconto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String codigo;
    @NotNull
    @Positive
    private Integer desconto;
    @Future
    private LocalDate validade;

    public CupomDesconto() {
    }

    public CupomDesconto(@NotEmpty String codigo, @NotNull @Positive Integer desconto, @Future LocalDate validade) {
        this.codigo = codigo;
        this.desconto = desconto;
        this.validade = validade;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public Integer getDesconto() {
        return desconto;
    }

    public LocalDate getValidade() {
        return validade;
    }
}
