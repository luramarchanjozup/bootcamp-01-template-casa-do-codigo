package br.com.zup.treinocasadocodigo.entities.estado;

/**
 * Contagem de carga intrínseca da classe: 2
 */

public class EstadoRetorno {

    private String nome;

    //1
    public EstadoRetorno(Estado estado) {
        //1
        this.nome = estado==null ? "" : estado.getNome();
    }

    public String getNome() {
        return nome;
    }
}
