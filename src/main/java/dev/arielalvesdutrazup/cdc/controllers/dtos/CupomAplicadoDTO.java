package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.embedded.CupomAplicado;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class CupomAplicadoDTO {

    private String codigo;
    private Integer percentualDeDesconto;
    private OffsetDateTime validade;

    public CupomAplicadoDTO() {
    }

    public CupomAplicadoDTO(CupomAplicado cupomAplicado) {
        setCodigo(cupomAplicado.getCodigo());
        setPercentualDeDesconto(cupomAplicado.getPercentualDeDesconto());
        setValidade(cupomAplicado.getValidade());
    }

    public String getCodigo() {
        return codigo;
    }

    public CupomAplicadoDTO setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public Integer getPercentualDeDesconto() {
        return percentualDeDesconto;
    }

    public CupomAplicadoDTO setPercentualDeDesconto(Integer percentualDeDesconto) {
        this.percentualDeDesconto = percentualDeDesconto;
        return this;
    }

    public OffsetDateTime getValidade() {
        return validade;
    }

    public CupomAplicadoDTO setValidade(OffsetDateTime validade) {
        this.validade = validade;
        return this;
    }

    @Override
    public String toString() {
        return "CupomAplicadoDTO{" +
                "codigo='" + codigo + '\'' +
                ", percentualDeDesconto=" + percentualDeDesconto +
                ", validade=" + validade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CupomAplicadoDTO that = (CupomAplicadoDTO) o;
        return Objects.equals(codigo, that.codigo) &&
                Objects.equals(percentualDeDesconto, that.percentualDeDesconto) &&
                Objects.equals(validade.truncatedTo(ChronoUnit.SECONDS).atZoneSameInstant(ZoneId.systemDefault())
                        , that.validade.truncatedTo(ChronoUnit.SECONDS).atZoneSameInstant(ZoneId.systemDefault()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, percentualDeDesconto, validade.truncatedTo(ChronoUnit.SECONDS).atZoneSameInstant(ZoneId.systemDefault()));
    }
}
