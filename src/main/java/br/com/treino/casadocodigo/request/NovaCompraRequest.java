package br.com.treino.casadocodigo.request;

import br.com.treino.casadocodigo.model.Compra;
import br.com.treino.casadocodigo.model.Estado;
import br.com.treino.casadocodigo.model.Pais;
import br.com.treino.casadocodigo.validations.CpfOuCnpj;
import br.com.treino.casadocodigo.validations.ExistId;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class NovaCompraRequest {

    private @NotBlank String nome;
    private @NotBlank String sobrenome;
    private @Email @NotBlank String email;
    @NotBlank
    @CpfOuCnpj(message = "Documento inválido")
    private String documento;
    @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}\\-\\d{4}$", message = "Telefone inválido")
    @NotBlank
    private String telefone;
    @NotNull
    @ExistId(className = Pais.class, fieldName = "id", message = "Esse país não foi encontrado")
    private Long idPais;

    @ExistId(className = Estado.class, fieldName = "id", message = "Esse estado não foi encontrado")
    private Long idEstado;

    private @NotBlank String cidade;
    private @NotBlank String endereco;
    @Pattern(regexp = "\\d{5}\\-\\d{3}" ,message = "CEP inválido")
    @NotBlank
    private String cep;
    private @NotBlank String complemento;

    public NovaCompraRequest(@NotBlank String nome, @NotBlank String sobrenome,
                             @Email @NotBlank String email, @NotBlank String documento,
                             @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}\\-\\d{4}$",
                                     message = "Telefone inválido") @NotBlank String telefone,
                             @NotNull Long idPais, Long idEstado, @NotBlank String cidade,
                             @NotBlank String endereco, @Pattern(regexp = "\\d{5}\\-\\d{3}",
            message = "CEP inválido") @NotBlank String cep, @NotBlank String complemento) {
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
    }

    public Compra toModel(EntityManager entityManager){ //3

        @NotNull Pais pais = entityManager.find(Pais.class, idPais); //1

        Compra compra = new Compra(this.nome, this.sobrenome,this.email, this.documento, this.telefone,
                pais, this.cidade, this.endereco, this.cep, this.complemento);

        if(idEstado != null){ //4
            compra.setEstado(entityManager.find(Estado.class, idEstado)); //2
        }
        return compra;
    }

}
