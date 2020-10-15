package br.com.carlos.casadocodigo.api.dto.response;

import br.com.carlos.casadocodigo.domain.entity.*;
import br.com.carlos.casadocodigo.domain.repository.PedidoRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ResponseDetalhesCompraDto {
    private final String nome;
    private final String endereco;
    private final String complemento;
    private final String cidade;
    private final String email;
    private final String telefone;
    private final String cep;
    private final List<ResponseItensDto> pedido;
    private final BigDecimal precoComDesconto;


    public ResponseDetalhesCompraDto(String nome, String endereco, String complemento, String cidade, String email,
                                     String telefone, String cep, List<ResponseItensDto> pedido, BigDecimal precoComDesconto) {
        this.nome = nome;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = pedido;
        this.precoComDesconto = precoComDesconto;
    }

    public static ResponseDetalhesCompraDto toDto(Compra compra, PedidoRepository pedidoRepository) {

        var precoTotal = pedidoRepository.valorTotalPedido(compra.getPedido().getId());
        var precoComDesconto = compra.totalComDesconto(precoTotal);
        var pedidos = compra.getPedido().getItens().stream().map(ResponseItensDto::converter).
                collect(Collectors.toList());

        return new ResponseDetalhesCompraDto(compra.getNome(), compra.getEndereco(), compra.getComplemento(),
                compra.getCidade(), compra.getEmail(), compra.getTelefone(), compra.getCep(), pedidos, precoComDesconto);
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public List<ResponseItensDto> getPedido() {
        return pedido;
    }

    public BigDecimal getPrecoComDesconto() {
        return precoComDesconto;
    }
}
