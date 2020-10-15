package br.com.carlos.casadocodigo.api.dto.response;

import br.com.carlos.casadocodigo.domain.entity.Categoria;

public class ResponseCategoriaId {

    private String nome;

    public static ResponseCategoriaId converter(Categoria c) {
        var categoria = new ResponseCategoriaId();
        categoria.setNome(c.getNome());
        return categoria;
    }

    public ResponseCategoriaId() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
