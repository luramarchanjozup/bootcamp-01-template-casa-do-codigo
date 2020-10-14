package br.com.ecommerce.cdc.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Embeddable;

/**
 * Carga intrínseca máxima permitida - 9
 * Carga intrínseca da classe - 0
 */

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class CupomDescontoAplicado {

    private String codigo;

    public CupomDescontoAplicado() {
    }

    public CupomDescontoAplicado(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
