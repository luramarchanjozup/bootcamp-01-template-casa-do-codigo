package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.ExistsById;
import br.com.carlos.casadocodigo.domain.entity.*;
import br.com.carlos.casadocodigo.domain.repository.CupomRepository;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class RequestCompraDto {

    @Email @NotBlank
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
    @NotNull @ExistsById(domainClass = Pais.class,fieldName = "id")
    private Long idPais;
    @NotNull
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    @Valid @NotNull
    private RequestPedidoDto pedido;
    private String codigoCupom;

    public RequestCompraDto(){}
                                                                    //1
    public Compra toEntity(EntityManager manager, CupomRepository cupomRepository) {
                                      //1
        var pais = manager.find(Pais.class, this.idPais);
                                          //1
        var estado = manager.find(Estado.class, this.idEstado);
        var cupom = cupomRepository.getByCodigo(getCodigoCupom());
                        //1
        var compra = new Compra(email, nome, sobrenome, documento, endereco, complemento,
                cidade, pais, estado, telefone, cep, pedido.toEntity(manager));
                //1
        compra.aplicaCupom(cupom.get());
        return compra;
    }
    public boolean documentoValido() {
        Assert.hasLength(documento, "documento null, não foi possível fazer a validação");

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

    public RequestPedidoDto getPedido() {
        return pedido;
    }

    public void setPedido(RequestPedidoDto pedido) {
        this.pedido = pedido;
    }

    public String getCodigoCupom() {
        return codigoCupom;
    }

    public void setCodigoCupom(String codigoCupom) {
        this.codigoCupom = codigoCupom;
    }

    @Override
    public String toString() {
        return "RequestCompraDto{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pais=" + idPais +
                ", estado=" + idEstado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", pedido=" + pedido +
                ", codigoCupom='" + codigoCupom + '\'' +
                '}';
    }
}
