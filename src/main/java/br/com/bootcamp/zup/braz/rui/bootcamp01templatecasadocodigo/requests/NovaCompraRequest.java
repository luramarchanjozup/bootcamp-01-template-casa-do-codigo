package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.annotation.ObjetoValido;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.*;
import org.springframework.lang.Nullable;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class NovaCompraRequest {

    @NotBlank
    @Email(message = "Fomato de email inválido.")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @Pattern(message = "Formato do documento inválido.", regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ObjetoValido(fieldName = "id", domainClass = Pais.class)
    private Integer idPais;
    private Integer idEstado;
    @NotBlank
    @Pattern(message = "Formato do telefone inválido.", regexp = "^[0-9]{2}-[0-9]{5}-[0-9]{4}$")
    private String telefone;
    @NotBlank
    @Pattern(message = "Formato do CEP inválido.", regexp = "^\\d{5}-\\d{3}$")
    private String cep;
    @Valid
    @NotNull
    private NovoPedidoRequest novoPedidoRequest;
    @ObjetoValido(domainClass = Cupom.class, fieldName = "id")
    private Integer idCupom;

    @Deprecated
    public NovaCompraRequest(){

    }

    public NovaCompraRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank @Pattern(message = "Formato do documento inválido.", regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})") String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Integer idPais, Integer idEstado, @NotBlank @Pattern(message = "Formato do telefone inválido", regexp = "^[0-9]{2}-[0-9]{4}-[0-9]{4}$") String telefone, @NotBlank @Pattern(message = "Formato do CEP inválido", regexp = "^\\d{5}-\\d{3}$") String cep, @Valid @NotNull NovoPedidoRequest novoPedidoRequest) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
        this.novoPedidoRequest = novoPedidoRequest;
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

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
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

    public NovoPedidoRequest getNovoPedidoRequest() {
        return novoPedidoRequest;
    }

    public void setNovoPedidoRequest(NovoPedidoRequest novoPedidoRequest) {
        this.novoPedidoRequest = novoPedidoRequest;
    }

    public Optional<Integer> getIdCupom() {
        return Optional.ofNullable(idCupom);
    }

    public void setIdCupom(@Nullable Integer idCupom) {
        this.idCupom = idCupom;
    }

    public Compra toModel(EntityManager entityManager) {
        @NotNull Pais pais = entityManager.find(Pais.class, idPais);

        Function<Compra, Pedido> funcaoCriacaoPedido = novoPedidoRequest.toModel(entityManager);

        Compra compra = new Compra(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep, funcaoCriacaoPedido);

        if (idEstado != null){
            compra.setEstado(entityManager.find(Estado.class, idEstado));
        }

        if (idCupom != null){
            Cupom cupom = entityManager.find(Cupom.class, idCupom);
            compra.aplicaCupom(cupom);
        }
        return compra;
    }



    public boolean temEstado(){
        return idEstado != null;
    }
}
