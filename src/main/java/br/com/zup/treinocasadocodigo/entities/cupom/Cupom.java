package br.com.zup.treinocasadocodigo.entities.cupom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Contagem de carga intrínseca da classe: 0
 */

@Entity
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String codigo;
    @NotNull
    @Positive
    @DecimalMax(value = "1", inclusive = false)
    private BigDecimal desconto;
    @NotNull
    @Future
    private LocalDate validade;

    protected Cupom(){}

    public Cupom(@NotEmpty String codigo, @NotNull @Positive BigDecimal desconto, @NotNull @Future LocalDate validade) {
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

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    @Override
    public String toString() {
        return "Cupom{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", desconto=" + desconto +
                ", validade=" + validade +
                '}';
    }

    public void autalizar(@Valid CupomAtualizadoRequest cupomAtualizado) {
        this.codigo = cupomAtualizado.getCodigo();
        this.desconto = cupomAtualizado.getDesconto();
        this.validade = cupomAtualizado.getValidade();
    }

    public boolean vencido(){
        LocalDate hoje = LocalDate.now();
        return this.validade.isBefore(hoje);
    }
}
