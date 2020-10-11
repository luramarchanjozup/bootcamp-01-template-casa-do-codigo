package com.cdcAPI.api.model.Response;

import com.cdcAPI.model.Cliente;
import com.cdcAPI.model.Compra;
import com.cdcAPI.model.Livro;

import java.math.BigDecimal;
import java.util.List;


public class CompraResponse {

    private ClienteResponse cliente;
    private List<Livro> livros;
    private BigDecimal total;
    private BigDecimal totalDesconto;

    public CompraResponse(Compra compra) {

        cliente = new ClienteResponse(compra.getCliente());
        livros = compra.getLivros();

        total = compra.getTotal();
        totalDesconto = compra.getTotalDesconto();
    }

    public ClienteResponse getCliente() {
        return cliente;
    }

    public void setCliente(ClienteResponse cliente) {
        this.cliente = cliente;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalDesconto() {
        return totalDesconto;
    }

    public void setTotalDesconto(BigDecimal totalDesconto) {
        this.totalDesconto = totalDesconto;
    }
}
