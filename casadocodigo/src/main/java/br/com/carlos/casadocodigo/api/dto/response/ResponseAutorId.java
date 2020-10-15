package br.com.carlos.casadocodigo.api.dto.response;

import br.com.carlos.casadocodigo.domain.entity.Autor;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
