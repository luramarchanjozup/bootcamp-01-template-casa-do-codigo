package dev.arielalvesdutrazup.cdc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.OffsetDateTime;

@Entity
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{codigo.notempty}")
    private String codigo;
    @Min(value = 1, message = "{percentualDeDesconto.min}")
    @Max(value = 100, message = "{percentualDeDesconto.max}")
    @NotNull(message = "{percentualDeDesconto.notnull}")
    private Integer percentualDeDesconto;
    @Future(message = "{validade.future}")
    @NotNull(message = "{validade.notnull}")
    private OffsetDateTime validade;
    private OffsetDateTime cadastradoEm = OffsetDateTime.now();
    private OffsetDateTime atualizadoEm;

    public Long getId() {
        return id;
    }

    public Cupom setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public Cupom setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public Integer getPercentualDeDesconto() {
        return percentualDeDesconto;
    }

    public Cupom setPercentualDeDesconto(Integer percentualDeDesconto) {
        this.percentualDeDesconto = percentualDeDesconto;
        return this;
    }

    public OffsetDateTime getValidade() {
        return validade;
    }

    public Cupom setValidade(OffsetDateTime validade) {
        this.validade = validade;
        return this;
    }

    public OffsetDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public Cupom setCadastradoEm(OffsetDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
        return this;
    }

    public OffsetDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public Cupom setAtualizadoEm(OffsetDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
        return this;
    }
}
