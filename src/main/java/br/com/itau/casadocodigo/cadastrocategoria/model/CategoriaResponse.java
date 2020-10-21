package br.com.itau.casadocodigo.cadastrocategoria.model;

public class CategoriaResponse {

    private Long id;
    private String nomeCategoria;

    public CategoriaResponse(Long id, String nomeCategoria) {
        this.id = id;
        this.nomeCategoria = nomeCategoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public CategoriaResponse (Categoria categoria) {
        this.id = categoria.getId();
        this.nomeCategoria = categoria.getNomeCategoria();
    }
}
