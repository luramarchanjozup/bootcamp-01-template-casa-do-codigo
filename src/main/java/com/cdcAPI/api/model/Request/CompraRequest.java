package com.cdcAPI.api.model.Request;

import com.cdcAPI.model.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompraRequest {

    @Valid
    private ClienteRequest cliente;
    @Valid
    private CarrinhoRequest carrinho;


    public Compra toModel(EntityManager manager) throws Exception {

        List<Livro> livros = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (CompraItemRequest item : carrinho.getItems()) {
            Livro livro = manager.find(Livro.class, item.getLivroId()); //Item possui Id do livro e qtd
            if (livro == null) throw new Exception("Livro não existe.");

            BigDecimal quantidade = BigDecimal.valueOf(item.getQuantidade());
            total = total.add(livro.getPreco().multiply(quantidade));
            livros.add(livro);
        }

        if (!total.equals(carrinho.getTotal())) throw new Exception("Valores não condizentes");

        Cupom cupom = manager.find(Cupom.class, cliente.getCupomId());
        if (cupom == null) {
            throw new Exception("Compra não pode ser efetuada. Cupom não existe.");
        } else if (!cupom.getValidade().isAfter(LocalDate.now())) {
            throw new Exception("Compra não pode ser efetuada. Cupom expirou.");
        }
        BigDecimal porcentagem = (cupom.getPorcentagem()).divide(BigDecimal.valueOf(100), RoundingMode.UP);
        BigDecimal totalComDesconto = total.subtract(total.multiply(porcentagem));

        return new Compra(cliente.toModel(manager), livros, total, totalComDesconto);
    }

    //get set
    public ClienteRequest getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRequest cliente) {
        this.cliente = cliente;
    }

    public CarrinhoRequest getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoRequest carrinho) {
        this.carrinho = carrinho;
    }
}
