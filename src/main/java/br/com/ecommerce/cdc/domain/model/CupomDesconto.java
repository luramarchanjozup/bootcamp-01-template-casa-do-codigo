package br.com.ecommerce.cdc.domain.model;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Carga Intrínseca máxima permitida - 9
 * Carga Intrínseca da classe - 1
 * */

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
    private Double desconto;
    @Future
    private LocalDate validade;

    public CupomDesconto() {
    }

    public CupomDesconto(@NotEmpty String codigo, @NotNull @Positive Double desconto, @Future LocalDate validade) {
        this.codigo = codigo;
        this.desconto = desconto;
        this.validade = validade;
    }

    public boolean cupomValido(){
        // +1
        if (this.getValidade().isAfter(LocalDate.now())){
            return true;
        }
        return false;
    }

    public BigDecimal desconto(){
        return new BigDecimal(this.desconto).divide(new BigDecimal(100));
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public Double getDesconto() {
        return desconto;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

}
