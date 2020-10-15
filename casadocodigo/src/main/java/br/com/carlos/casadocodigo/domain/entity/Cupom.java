package br.com.carlos.casadocodigo.domain.entity;

import br.com.carlos.casadocodigo.api.handler.Unique;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cupom")
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Unique(domainClass = Cupom.class, fieldName = "codigo")
    private  String codigo;
    @Positive
    private BigDecimal percentualDesconto;
    @Future
    private LocalDate validade;

    @Deprecated
    public Cupom() {}

    public Cupom(String codigo, BigDecimal percentualDesconto, LocalDate validade) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
        this.validade = validade;
    }

    public boolean valido() {
        return LocalDate.now().compareTo(this.validade) <= 0;
    }

    public Cupom atualizaCupom(Cupom cupomNovo, Cupom request){
        cupomNovo.setCodigo(request.getCodigo());
        cupomNovo.setPercentualDesconto(request.getPercentualDesconto());
        cupomNovo.setValidade(request.getValidade());
        return cupomNovo;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(BigDecimal percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
