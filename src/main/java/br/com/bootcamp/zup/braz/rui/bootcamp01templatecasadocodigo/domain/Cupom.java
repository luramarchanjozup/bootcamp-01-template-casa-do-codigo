package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
@Table(name = "t_cupom")
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String codigo;
    @NotNull
    @Positive
    private Integer desconto;
    @NotNull
    @Future
    private LocalDate validade;

    @Deprecated
    public Cupom(){}

    public Cupom(@NotBlank String codigo, @NotNull @Positive Integer desconto, @NotNull @Future LocalDate validade) {
        this.codigo = codigo;
        this.desconto = desconto;
        this.validade = validade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getDesconto() {
        return desconto;
    }

    public void setDesconto(Integer desconto) {
        this.desconto = desconto;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public boolean isValido(){
        return LocalDate.now().compareTo(this.validade) <= 0;
    }

}
