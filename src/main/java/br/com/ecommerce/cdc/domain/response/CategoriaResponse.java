package br.com.ecommerce.cdc.domain.response;

import br.com.ecommerce.cdc.domain.model.Categoria;

import javax.validation.constraints.NotBlank;

/**
 * Carga Intrínseca máxima permitida - 9
 * Carga Intrínseca da classe - 1
 *
 */

public class CategoriaResponse {

    private Long id;
    @NotBlank
    private String nome;

    // +1
    public CategoriaResponse(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
