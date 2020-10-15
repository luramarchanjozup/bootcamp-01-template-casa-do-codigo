package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.ExistsById;
import br.com.carlos.casadocodigo.domain.entity.*;
import br.com.carlos.casadocodigo.domain.repository.CupomRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter @Setter
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
