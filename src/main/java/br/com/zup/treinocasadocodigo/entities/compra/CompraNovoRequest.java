package br.com.zup.treinocasadocodigo.entities.compra;

import br.com.zup.treinocasadocodigo.entities.compra.itemcompra.ItemCompra;
import br.com.zup.treinocasadocodigo.entities.estado.Estado;
import br.com.zup.treinocasadocodigo.entities.pais.Pais;
import br.com.zup.treinocasadocodigo.validators.cpfcnpj.CpfCnpj;
import br.com.zup.treinocasadocodigo.validators.existid.ExistId;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Contagem de carga intrínseca da classe: 9
 */

public class CompraNovoRequest {

    //Dados do comprador
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    //1
    @CpfCnpj
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    //1
    @ExistId(dominioClasse = Pais.class, nomeCampo = "id")
    private Long idPais;
    @ExistId(dominioClasse = Estado.class, nomeCampo = "id")
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    //Dados da compra
    @NotNull
    @Valid
    //1
    private PedidoCompraNovoRequest pedido;

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

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public PedidoCompraNovoRequest getPedido() {
        return pedido;
    }

    public void setPedido(PedidoCompraNovoRequest pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "CompraRequest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", idPais=" + idPais +
                ", idEstado=" + idEstado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", pedido={" + pedido + "}" +
                '}';
    }

    //1
    public Compra toModel(EntityManager manager){

        //1
        Pais pais = manager.find(Pais.class, this.idPais);
        //1
        Estado estado = null;
        //1
        if (this.idEstado != null) {
            estado = manager.find(Estado.class, this.idEstado);
        }
        //2
        List<ItemCompra> itens = this.pedido.getItens()
                .stream()
                .map(itemRequest -> itemRequest.toModel(manager))
                .collect(Collectors.toList());

        Compra compra = new Compra(this.email, this.nome, this.sobrenome, this.documento,
                this.endereco, this.complemento, this.cidade, pais, estado,
                this.telefone, this.cep, itens, this.pedido.getTotal());
        compra.setCupom(this.pedido.getCodigoCupom(), manager);

        return compra;
    }
}
