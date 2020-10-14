package br.com.zup.treinocasadocodigo.entities.estado;

/**
 * Contagem de carga intrínseca da classe: 3
 */

public class EstadoRetorno {

    private String nome;

    //1
    public EstadoRetorno(Estado estado) {
        //2
        this.nome = estado==null ? "" : estado.getNome();
    }

    public String getNome() {
        return nome;
    }
}
