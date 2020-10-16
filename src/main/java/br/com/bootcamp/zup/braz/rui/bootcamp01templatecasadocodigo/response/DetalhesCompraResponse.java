package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.response;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Compra;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Pedido;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class DetalhesCompraResponse {

    @NotBlank
    private String documento;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String telefone;
    @NotBlank
    private String email;
    @NotBlank
    private String cep;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotBlank
    private String pais;
    private String estado;
    @NotNull
    private BigDecimal totalPedido;
    @NotNull
    private PedidoResponse pedidoResponse;
    private String cupomAplicado;
    private Integer percentualDesconto;
    private BigDecimal totalComDesconto;

    public DetalhesCompraResponse(Compra compra, Pedido pedido){
        this.documento = compra.getDocumento();
        this.nome = compra.getNome();
        this.sobrenome = compra.getSobrenome();
        this.telefone = compra.getTelefone();
        this.email = compra.getEmail();
        this.cep = compra.getCep();
        this.endereco = compra.getEndereco();
        this.complemento = compra.getComplemento();
        this.cidade = compra.getCidade();
        this.pais = compra.getPais().getNome();
        this.totalPedido;
    }



}
