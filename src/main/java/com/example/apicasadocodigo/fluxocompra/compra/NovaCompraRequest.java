package com.example.apicasadocodigo.fluxocompra.compra;

import com.example.apicasadocodigo.compartilhado.ExistsId;
import com.example.apicasadocodigo.fluxocompra.cupom.Cupom;
import com.example.apicasadocodigo.fluxocompra.cupom.CupomRepository;
import com.example.apicasadocodigo.fluxocompra.pedido.NovoPedidoRequest;
import com.example.apicasadocodigo.fluxocompra.pedido.Pedido;
import com.example.apicasadocodigo.localidade.Estado;
import com.example.apicasadocodigo.localidade.Pais;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.function.Function;

public class NovaCompraRequest {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;
    @ExistsId(domainClass = Estado.class, fieldName = "id")
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    @Valid
    @NotNull
    private NovoPedidoRequest pedido;
    @ExistsId(domainClass = Cupom.class, fieldName = "codigo")
    private String codigoCupom;

    public Compra toModel(EntityManager manager, CupomRepository cupomRepository) {
        @NotNull Pais pais = manager.find(Pais.class, idPais);

        Function<Compra, Pedido> funcaoCriacaoPedido = pedido.toModel(manager);

        Compra compra = new Compra(email, nome, sobrenome, documento, endereco, complemento, cidade,
                pais, telefone, cep, funcaoCriacaoPedido);
        if (idEstado != null) {
            compra.setEstado(manager.find(Estado.class, idEstado));
        }
        if (StringUtils.hasText(codigoCupom)) {
            Cupom cupom = cupomRepository.findByCodigo(codigoCupom);
            compra.aplicarCupom(cupom);
        }

        return compra;
    }

    public boolean documentoValido() {
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public NovoPedidoRequest getPedido() {
        return pedido;
    }

    public void setPedido(NovoPedidoRequest pedido) {
        this.pedido = pedido;
    }

    public Optional<String> getCodigoCupom() {
        return Optional.ofNullable(codigoCupom);
    }

    public void setCodigoCupom(String codigoCupom) {
        this.codigoCupom = codigoCupom;
    }
}
