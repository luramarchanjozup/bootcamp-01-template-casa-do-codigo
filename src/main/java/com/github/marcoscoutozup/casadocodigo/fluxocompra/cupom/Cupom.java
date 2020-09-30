package com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Cupom {

    @Id
    @GeneratedValue(generator = "uuid4")
    private UUID id;

    @NotBlank
    private String codigo;

    @NotNull
    @Positive
    private Integer percentual;

    @Future
    private LocalDate validade;

    @Deprecated
    public Cupom() {
    }

    public Cupom(@NotBlank String codigo, @NotNull @Positive Integer percentual, @Future LocalDate validade) {
        this.codigo = codigo;
        this.percentual = percentual;
        this.validade = validade;
    }

    @Override
    public String toString() {
        return "Cupom{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", percentual=" + percentual +
                ", validade=" + validade +
                '}';
    }
}
