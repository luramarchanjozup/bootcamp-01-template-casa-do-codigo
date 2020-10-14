package br.com.zup.treinocasadocodigo.entities.pais;

/**
 * Contagem de carga intrínseca da classe: 1
 */

public class PaisRetorno {

    private String nome;

    //1
    public PaisRetorno(Pais pais) {
        this.nome = pais.getNome();
    }

    public String getNome() {
        return nome;
    }
}
