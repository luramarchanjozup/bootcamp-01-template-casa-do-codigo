package br.com.itau.casadocodigo.cadastrocupom.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CupomResponse {

    private final Long id;
    private final String codigo;
    private final BigDecimal percentual;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private final LocalDate validade;

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getPercentual() {
        return percentual;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public CupomResponse(Cupom cupom) {
        this.id = cupom.getId();
        this.codigo = cupom.getCodigo();
        this.percentual = cupom.getPercentual();
        this.validade = cupom.getValidade();
    }
}
