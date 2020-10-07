package br.com.treino.casadocodigo.model;

import br.com.treino.casadocodigo.validations.UniqueValue;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @UniqueValue(className = Cupom.class, fieldName = "codigo")
    private String codigo;
    @NotNull @Future
    private LocalDate validade;

    public Cupom(@NotBlank String codigo, @Future LocalDate validade) {
        this.codigo = codigo;
        this.validade = validade;
    }

    public String getCodigo() { return codigo; }

    public LocalDate getValidade() { return validade; }

}
