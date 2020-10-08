package br.com.carlos.casadocodigo.api.dto;

import br.com.carlos.casadocodigo.domain.entity.Categoria;
import lombok.Data;

@Data
public class ResponseCategoriaId {

    private String nome;

    public static ResponseCategoriaId converter(Categoria c) {
        var categoria = new ResponseCategoriaId();
        categoria.setNome(c.getNome());
        return categoria;
    }
}
