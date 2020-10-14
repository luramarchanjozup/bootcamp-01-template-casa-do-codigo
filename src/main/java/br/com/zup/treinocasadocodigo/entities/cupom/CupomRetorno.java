package br.com.zup.treinocasadocodigo.entities.cupom;

import java.math.BigDecimal;

/**
 * Contagem de carga intrínseca da classe: 3
 */


public class CupomRetorno {
    private String codigo;
    private BigDecimal desconto;

    //1
    public CupomRetorno (Cupom cupom) {
        //2
        if (cupom == null) {
            this.codigo = "";
            this.desconto = new BigDecimal("0");
        } else {
            this.codigo = cupom.getCodigo();
            this.desconto = cupom.getDesconto();
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }
}
