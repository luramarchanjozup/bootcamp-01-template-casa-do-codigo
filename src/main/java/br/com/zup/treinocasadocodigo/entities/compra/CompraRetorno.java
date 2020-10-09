package br.com.zup.treinocasadocodigo.entities.compra;

import br.com.zup.treinocasadocodigo.entities.compra.itemcompra.ItemCompra;
import br.com.zup.treinocasadocodigo.entities.compra.itemcompra.ItemCompraRetorno;
import br.com.zup.treinocasadocodigo.entities.estado.EstadoRetorno;
import br.com.zup.treinocasadocodigo.entities.pais.PaisRetorno;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Contagem de carga intrínseca da classe: 6
 */

public class CompraRetorno {
    //Dados do comprador
    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    //1
    private PaisRetorno pais;
    //1
    private EstadoRetorno estado;
    private String telefone;
    private String cep;

    //Dados da compra
    //1
    private List<ItemCompraRetorno> listaItens;
    private BigDecimal totalSemDesconto;
    private BigDecimal totalCompra;

    //1
    public CompraRetorno(Compra compra) {
        this.email = compra.getEmail();
        this.nome = compra.getNome();
        this.sobrenome = compra.getSobrenome();
        this.documento = compra.getDocumento();
        this.endereco = compra.getEndereco();
        this.complemento = compra.getComplemento();
        this.cidade = compra.getCidade();
        this.pais = new PaisRetorno(compra.getPais());
        this.estado = new EstadoRetorno(compra.getEstado());
        this.telefone = compra.getTelefone();
        this.cep = compra.getCep();
        this.listaItens = compra.getListaItens()
                .stream().map(ItemCompraRetorno::new)
                .collect(Collectors.toList());
        this.totalCompra = compra.getTotal();
        this.totalSemDesconto = calculaTotalSemDesconto(compra);
    }

    private BigDecimal calculaTotalSemDesconto(Compra compra) {

        BigDecimal valorCalculado = new BigDecimal("0");

        //2
        for(ItemCompra item : compra.getListaItens()) {
            BigDecimal valorItem = item.getLivro().getPreco()
                    .multiply(new BigDecimal(item.getQuantidade()));
            valorCalculado = valorCalculado.add(valorItem);
        }
        return valorCalculado;

    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
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

    public PaisRetorno getPais() {
        return pais;
    }

    public EstadoRetorno getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public List<ItemCompraRetorno> getListaItens() {
        return listaItens;
    }

    public BigDecimal getTotalSemDesconto() {
        return totalSemDesconto;
    }

    public BigDecimal getTotalCompra() {
        return totalCompra;
    }
}
