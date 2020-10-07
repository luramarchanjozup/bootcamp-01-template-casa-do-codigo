package br.com.zup.treinocasadocodigo.entities.estado;

import br.com.zup.treinocasadocodigo.entities.pais.Pais;
import br.com.zup.treinocasadocodigo.validators.existid.ExistId;
import br.com.zup.treinocasadocodigo.validators.uniquevalue.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Contagem de carga intrínseca da classe: 1
 */

public class EstadoNovoRequest {

    @NotBlank
    @UniqueValue(dominioClasse = Estado.class, nomeCampo = "nome")
    private String nome;

    @NotNull
    @ExistId(dominioClasse = Pais.class, nomeCampo = "id")
    private Long idPais;

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Estado toModel(EntityManager manager) {
        //1
        Pais pais = manager.find(Pais.class, this.idPais);

        Assert.notNull(pais, "O Estado não existe");

        return new Estado(this.nome, pais);
    }
}
