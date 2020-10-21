package br.com.itau.casadocodigo.cadastropaisestado.model;

import br.com.itau.casadocodigo.validador.AtributoNaoExistente;
import br.com.itau.casadocodigo.validador.AtributoUnico;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank
    @AtributoUnico(nomeDoAtributo = "estado", classeDeDominio = Estado.class)
    private String estado;

    @NotNull
    @AtributoNaoExistente(nomeDoAtributo = "id", classeDeDominio = Pais.class)
    private Long idPais;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }
//1
    public Estado toModel(EntityManager entityManager) {
        @NotNull
        Pais paisSelecionado = entityManager.find(Pais.class, this.idPais);
        return new Estado(this.estado, paisSelecionado);
    }
}
