package br.com.ecommerce.cdc.domain.request;

import br.com.ecommerce.cdc.anotacao.NotDuplicated;
import br.com.ecommerce.cdc.domain.model.Pais;

import javax.validation.constraints.NotBlank;

/**
 * Carga intrínseca máxima permitida - 9
 * Carga intrínseca da classe - 1
 */

public class PaisRequest {

    @NotBlank
    @NotDuplicated(nameClass = "Pais", fieldName = "nome")
    private String nome;

    public PaisRequest() {
    }

    public PaisRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // +1
    public Pais toModel(){
        return new Pais(this.nome);
    }

    @Override
    public String toString() {
        return "PaisRequest{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
