package br.com.ecommerce.cdc.domain.request;

import br.com.ecommerce.cdc.anotacao.CupomValido;
import br.com.ecommerce.cdc.domain.model.CupomDescontoAplicado;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;

/**
 * Carga intrínseca máxima permitida - 9
 * Carga intrínseca da classe - 0
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CupomDescontoAplicadoRequest {

    @NotBlank
    @CupomValido
    private String codigo;

    public CupomDescontoAplicadoRequest() {
    }

    public CupomDescontoAplicadoRequest(@NotBlank String codigo) {
        this.codigo = codigo;
    }

    public CupomDescontoAplicado toModel(){
        return new CupomDescontoAplicado(this.codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
