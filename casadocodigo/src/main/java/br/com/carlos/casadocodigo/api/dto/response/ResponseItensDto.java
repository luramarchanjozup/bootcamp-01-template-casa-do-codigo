package br.com.carlos.casadocodigo.api.dto.response;
import br.com.carlos.casadocodigo.domain.entity.ItemPedido;

import java.math.BigDecimal;

public class ResponseItensDto {

    private String livro;
    private  int quantidade;
    private BigDecimal precoMomento;

    public ResponseItensDto() { }



    public static ResponseItensDto converter(ItemPedido p) {
        var itens = new ResponseItensDto();
        itens.setLivro(p.getLivro().getTitulo());
        itens.setQuantidade(p.getQuantidade());
        itens.setPrecoMomento(p.getPrecoMomento());
        return itens;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoMomento() {
        return precoMomento;
    }

    public void setPrecoMomento(BigDecimal precoMomento) {
        this.precoMomento = precoMomento;
    }
}
