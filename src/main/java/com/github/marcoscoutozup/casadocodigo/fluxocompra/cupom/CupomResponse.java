package com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class CupomResponse {

    private String codigo;
    private Integer percentual;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate validade;

                        //1
    public CupomResponse(Cupom cupom) {
        //2
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
