package dev.arielalvesdutrazup.cdc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Entity
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private Integer percentualDeDesconto = 0;
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
