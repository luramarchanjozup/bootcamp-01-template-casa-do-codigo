package br.com.zup.treinocasadocodigo.entities.estado;

/**
 * Contagem de carga intrínseca da classe: 0
 */

public class EstadoRetorno {

    private String nome;

    public EstadoRetorno(Estado estado) {
        this.nome = estado.getNome();
    }

    public String getNome() {
        return nome;
    }
}
