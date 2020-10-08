package br.com.zup.treinocasadocodigo.entities.compra.itemcompra;

import br.com.zup.treinocasadocodigo.entities.livro.LivroRetornoLista;

/**
 * Contagem de carga intrínseca da classe: 2
 */

public class ItemCompraRetorno {

    //1
    private LivroRetornoLista livro;
    private int quantidade;

    //1
    public ItemCompraRetorno(ItemCompra item) {
        this.quantidade = item.getQuantidade();
        this.livro = new LivroRetornoLista(item.getLivro());
    }

    public LivroRetornoLista getLivro() {
        return livro;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
