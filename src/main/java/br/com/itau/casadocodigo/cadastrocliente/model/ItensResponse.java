package br.com.itau.casadocodigo.cadastrocliente.model;

public class ItensResponse {

    private final Long idLivro;
    private final Long quantidade;

    public ItensResponse(Long idLivro, Long quantidade) {
        this.idLivro = idLivro;
        this.quantidade = quantidade;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public Long getQuantidade() {
        return quantidade;
    }
}
