package br.com.itau.casadocodigo.cadastrocupom.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String codigo;
    @NotNull
    @Positive
    private BigDecimal percentual;
    @Future
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate validade;

    @Deprecated
    public Cupom() {
    }

    public Cupom(@NotBlank String codigo, @NotNull @Positive BigDecimal percentual, @Future LocalDate validade) {
        this.codigo = codigo;
        this.percentual = percentual;
        this.validade = validade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPercentual() {
        return percentual;
    }

    public void setPercentual(BigDecimal percentual) {
        this.percentual = percentual;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public void atualizaCupom(Long id, EntityManager entityManager) {
        Cupom cupomCadastrado = entityManager.find(Cupom.class, id); //1

        if (cupomCadastrado == null) { //1
            return;
        }

        if (!this.codigo.equals(cupomCadastrado.getCodigo())) { //1 1
            Query query = entityManager.createQuery("select 1 from " + this.getClass().getName() + " where codigo =:value");
            query.setParameter("value", this.codigo);
            if (!query.getResultList().isEmpty()) {
                return;
            }
        }

        this.id = cupomCadastrado.getId();
        entityManager.merge(this);
    }

    public Boolean ehValido() {
        return LocalDate.now().compareTo(this.validade) < 0;
    }
}
