package br.com.carlos.casadocodigo.api.dto.response;

import br.com.carlos.casadocodigo.domain.entity.Autor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseAutorId {
    private String nome;
    private String email;
    private String descricao;

    public static ResponseAutorId converter(Autor a) {
        var autor = new ResponseAutorId();
        autor.setNome(a.getNome());
        autor.setDescricao(a.getDescricao());
        autor.setEmail(a.getEmail());

        return autor;
    }
}
