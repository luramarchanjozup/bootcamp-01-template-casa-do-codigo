package br.com.zup.treinocasadocodigo.entities.compra;

import br.com.zup.treinocasadocodigo.entities.compra.itemcompra.ItemCompra;
import br.com.zup.treinocasadocodigo.entities.compra.itemcompra.ItemCompraRetorno;
import br.com.zup.treinocasadocodigo.entities.cupom.CupomRetorno;
import br.com.zup.treinocasadocodigo.entities.estado.EstadoRetorno;
import br.com.zup.treinocasadocodigo.entities.pais.PaisRetorno;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Contagem de carga intrínseca da classe: 7
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
    private String pais;
    private String estado;
    private String telefone;
    private String cep;

    //Dados da compra
    //1
    private List<ItemCompraRetorno> listaItens;
    //1
    private CupomRetorno cupom;
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
        this.pais = compra.getPais().getNome();
        //1
        this.estado = compra.getEstado() == null ? "" : compra.getEstado().getNome();
        this.telefone = compra.getTelefone();
        this.cep = compra.getCep();
        //1
        this.listaItens = compra.getListaItens()
                .stream().map(ItemCompraRetorno::new)
                .collect(Collectors.toList());
        this.cupom = new CupomRetorno(compra.getCupom());
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

    public String getPais() {
        return pais;
    }

    public String getEstado() {
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

    public CupomRetorno getCupom() {
        return cupom;
    }
}
