package dev.arielalvesdutrazup.cdc.entities.embedded;

import dev.arielalvesdutrazup.cdc.entities.Cupom;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.time.OffsetDateTime;

// 1 Cupom.java
@Embeddable
public class CupomAplicado {

    private String codigo;
    private OffsetDateTime validade;
    private Integer percentualDeDesconto;
    @ManyToOne
    private Cupom cupom;

    public CupomAplicado() {
    }

    public CupomAplicado(Cupom cupom) {
        setCodigo(cupom.getCodigo());
        setValidade(cupom.getValidade());
        setPercentualDeDesconto(cupom.getPercentualDeDesconto());
        setCupom(cupom);
    }

    public String getCodigo() {
        return codigo;
    }

    public CupomAplicado setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public OffsetDateTime getValidade() {
        return validade;
    }

    public CupomAplicado setValidade(OffsetDateTime validade) {
        this.validade = validade;
        return this;
    }

    public Integer getPercentualDeDesconto() {
        return percentualDeDesconto;
    }

    public CupomAplicado setPercentualDeDesconto(Integer percentualDeDesconto) {
        this.percentualDeDesconto = percentualDeDesconto;
        return this;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public CupomAplicado setCupom(Cupom cupom) {
        this.cupom = cupom;
        return this;
    }

    @Override
    public String toString() {
        return "CupomAplicado{" +
                "codigo='" + codigo + '\'' +
                ", validade=" + validade +
                ", percentualDeDesconto=" + percentualDeDesconto +
                '}';
    }
}
