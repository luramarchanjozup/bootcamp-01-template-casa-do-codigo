package com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom;

import javax.validation.constraints.NotNull;

public class AplicarCupomDTO {

    private String codigo;

    public boolean validarCupom(@NotNull CupomRepository cupomRepository){
        Cupom cupom = cupomRepository.findByCodigo(codigo).get();
        return cupom != null && cupom.estaValido();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
