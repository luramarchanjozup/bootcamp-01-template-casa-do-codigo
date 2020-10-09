package br.com.zup.treinocasadocodigo.entities.cupom;

import br.com.zup.treinocasadocodigo.validators.uniquevalue.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Contagem de carga intrínseca da classe: 2
 */

public class CupomNovoRequest {

    @NotEmpty
    //1
    @UniqueValue(dominioClasse = Cupom.class, nomeCampo = "codigo")
    private String codigo;

    @NotNull
    @Positive
    @DecimalMax(value = "1", inclusive = false)
    private BigDecimal desconto;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate validade;

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public LocalDate getValidade() {
        return validade;
    }

    //1
    public Cupom toModel(){
        return new Cupom(this.codigo, this.desconto, this.validade);
    }

}
