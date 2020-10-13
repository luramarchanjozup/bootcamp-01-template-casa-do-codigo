package br.com.treino.casadocodigo.request;

import br.com.treino.casadocodigo.model.*;
import br.com.treino.casadocodigo.repository.CupomRepositoy;
import br.com.treino.casadocodigo.validations.CpfOuCnpj;
import br.com.treino.casadocodigo.validations.ExistId;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Optional;

public class NovaCompraRequest {

    private @NotBlank String nome;
    private @NotBlank String sobrenome;
    private @Email @NotBlank String email;
    @CpfOuCnpj(message = "Documento inválido")
    private @NotBlank String documento;
    @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}\\-\\d{4}$", message = "Telefone inválido")
    private @NotBlank String telefone;
    @ExistId(className = Pais.class, fieldName = "id", message = "Esse país não foi encontrado")
    private @NotNull Long idPais;
    @ExistId(className = Estado.class, fieldName = "id", message = "Esse estado não foi encontrado")
    private Long idEstado;
    private @NotBlank String cidade;
    private @NotBlank String endereco;
    @Pattern(regexp = "\\d{5}\\-\\d{3}" ,message = "CEP inválido")
    private @NotBlank String cep;
    private @NotBlank String complemento;
    private @NotNull NovoPedidoRequest novoPedido;
    @ExistId(className = Cupom.class, fieldName = "codigo",
            message = "Esse cupom não existe")
    private String codigoCupom;

    public NovaCompraRequest(@NotBlank String nome, @NotBlank String sobrenome,
                             @Email @NotBlank String email, @NotBlank String documento,
                             @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}\\-\\d{4}$",
                                     message = "Telefone inválido") @NotBlank String telefone,
                             @NotNull Long idPais, Long idEstado, @NotBlank String cidade,
                             @NotBlank String endereco, @Pattern(regexp = "\\d{5}\\-\\d{3}",
            message = "CEP inválido") @NotBlank String cep,
                             @NotBlank String complemento, @NotNull NovoPedidoRequest novoPedido) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.telefone = telefone;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.cidade = cidade;
        this.endereco = endereco;
        this.cep = cep;
        this.complemento = complemento;
        this.novoPedido = novoPedido;
    }

    public Long getIdPais() { return idPais; }

    public Long getIdEstado() { return idEstado; }

    public void setCodigoCupom(String codigoCupom) {
        this.codigoCupom = codigoCupom;
    }

    public Optional<String> getCodigoCupom() {
        return Optional.ofNullable(codigoCupom);
    }

    public Compra toModel(EntityManager entityManager, CupomRepositoy cupomRepositoy){ //3

        @NotNull Pais pais = entityManager.find(Pais.class, idPais); //1

        Pedido pedido = novoPedido.toModel(entityManager);

        Compra compra = new Compra(this.nome, this.sobrenome,this.email,
                this.documento, this.telefone, pais,
                this.cidade, this.endereco, this.cep, this.complemento, pedido);

        if(idEstado != null){ //4
            compra.setEstado(entityManager.find(Estado.class, idEstado)); //2
        }

        if (StringUtils.hasText(codigoCupom)){ //5
            Cupom cupom = cupomRepositoy.getByCodigo(codigoCupom);
            compra.aplicarCupom(cupom);
        }

        return compra;
    }

    public Boolean temEstado(){
        return idEstado != null;
    }

}
