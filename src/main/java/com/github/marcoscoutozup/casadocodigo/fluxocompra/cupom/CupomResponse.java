package com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom;

import java.time.LocalDate;

public class CupomResponse {

    private String codigo;
    private Integer percentual;
    private LocalDate validade;

    public CupomResponse(Cupom cupom) {
        if(cupom != null){
            this.codigo = cupom.getCodigo();
            this.percentual = cupom.getPercentual();
            this.validade = cupom.getValidade();
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public Integer getPercentual() {
        return percentual;
    }

    public LocalDate getValidade() {
        return validade;
    }
}
