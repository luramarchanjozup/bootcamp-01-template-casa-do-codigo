package io.github.evertoncnsouza.rest.dto;

import io.github.evertoncnsouza.domain.entity.Compra;
import java.math.BigDecimal;
public class DetalheCompraResponse {

    private boolean existeCupom;
    private BigDecimal valorCupom;
    private PedidoResponse pedido;
    private String pais;
    private String cidade;
    private String endereco;
    private String sobrenome;
    private String nome;
    private String estado;

    public DetalheCompraResponse(Compra compra) {
        nome = compra.getNome();
        sobrenome = compra.getSobrenome();
        endereco = compra.getEndereco();
        cidade = compra.getCidade();
        pais = compra.getPais().getNome();
        compra.getEstado().ifPresent(estado -> this.estado = estado.getNome());
        this.pedido = new PedidoResponse(compra.getPedido());
        compra.getCupomAplicado().ifPresent( cupom -> {
            this.existeCupom = true;
            this.valorCupom = compra.getValorDesconto();
        });
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public PedidoResponse getPedido() {
        return pedido;
    }

    public boolean isExisteCupom() {
        return existeCupom;
    }

    public BigDecimal getValorCupom() {
        return valorCupom;
    }
    public BigDecimal getTotalComDescontos() {
       return pedido.getTotal().subtract(valorCupom);
    }
}