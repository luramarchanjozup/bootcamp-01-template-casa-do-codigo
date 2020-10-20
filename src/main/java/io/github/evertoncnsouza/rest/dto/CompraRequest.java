package io.github.evertoncnsouza.rest.dto;

import io.github.evertoncnsouza.domain.entity.Compra;
import io.github.evertoncnsouza.domain.entity.Cupom;
import io.github.evertoncnsouza.domain.repository.CupomRepository;
import io.github.evertoncnsouza.domain.entity.Estado;
import io.github.evertoncnsouza.domain.entity.Pais;
import io.github.evertoncnsouza.domain.entity.Pedido;
import io.github.evertoncnsouza.validation.constraint.valitation.ExistsId;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.function.Function;

public class CompraRequest {

    @NotBlank
    @Email
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
    private PedidoRequest pedido;
    //PCI 1;

    @ExistsId(domainClass = Cupom.class, fieldName = "codigo")
    private String codigoCupom;

    public CompraRequest(@NotBlank @Email String email, @NotBlank String nome,
                         @NotBlank String sobrenome, @NotBlank String documento,
                         @NotBlank String endereco, @NotBlank String complemento,
                         @NotBlank String cidade, @NotNull Long idPais,
                         @NotBlank String telefone, @NotBlank String cep, @Valid @NotNull PedidoRequest pedido) {
        super(); //Chama o construtor da classe mãe;
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = pedido;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public void setCodigoCupom(String codigoCupom) {
        this.codigoCupom = codigoCupom;
    }

    public Optional<String> getCodigoCupom() {
        return Optional.ofNullable(codigoCupom);
    }


    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }


    public PedidoRequest getPedido() {
        return pedido;
    }

    public String getDocumento() {
        return documento;
    }


    public boolean documentoValido() {
        Assert.hasLength(documento, "você não deveria validar o documento se ele não estiver preenchido");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        //PCI 2;
        return cpfValidator.isValid(documento, null)
                || cnpjValidator.isValid(documento, null);

    }


    //PCI 3;
    public Compra toModel(EntityManager manager, CupomRepository cupomRepository) {
        Pais pais = manager.find(Pais.class, idPais);
        Function<Compra, Pedido> funcaoCriacaoPedido = pedido.toModel(manager);

        Compra compra = new Compra(email, nome, sobrenome, cidade, documento, endereco, complemento,
                pais, telefone, cep, funcaoCriacaoPedido);

        if (idEstado != null) {
            compra.setEstado(manager.find(Estado.class, idEstado));
        }
   Optional<Cupom> possivelCupom = cupomRepository.findByCodigo(this.codigoCupom);
        possivelCupom.ifPresent(cupom -> compra.aplicaCupom(cupom));
  return compra;
    }
    public boolean temEstado() {
        return idEstado != null;
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
                ", pedido=" + pedido +
                '}';
    }
}