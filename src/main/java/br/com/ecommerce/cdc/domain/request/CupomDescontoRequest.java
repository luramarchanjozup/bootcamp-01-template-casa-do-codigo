package br.com.ecommerce.cdc.domain.request;

import br.com.ecommerce.cdc.anotacao.NotDuplicated;
import br.com.ecommerce.cdc.domain.model.CupomDesconto;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
/**
 * Carga Intrínseca máxima permitida - 9
 * Carga Intrínseca da classe - 1
 * */
public class CupomDescontoRequest {

    @NotEmpty
    @NotDuplicated(fieldName = "codigo", nameClass = "CupomDesconto")
    private String codigo;
    @NotNull
    @Positive
    private Double desconto;
    @Future
    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    @NotNull
    private LocalDate validade;

    public CupomDescontoRequest(@NotEmpty String codigo, @NotNull @Positive Double desconto, @Future @NotNull LocalDate validade) {
        this.codigo = codigo;
        this.desconto = desconto;
        this.validade = validade;
    }

    // +1
    public CupomDesconto toModel(){
        return new CupomDesconto(this.codigo,this.desconto,this.validade);
    }

    @Override
    public String toString() {
        return "CupomDescontoRequest{" +
                "codigo='" + codigo + '\'' +
                ", desconto=" + desconto +
                ", validade=" + validade +
                '}';
    }
}
