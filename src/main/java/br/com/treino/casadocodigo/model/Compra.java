package br.com.treino.casadocodigo.model;

import br.com.treino.casadocodigo.validations.CpfOuCnpj;
import br.com.treino.casadocodigo.validations.ExistId;

import javax.validation.constraints.*;

public class Compra {

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
    @ExistId(className = Pais.class, fieldName = "id")
    private  Pais pais;
    @ExistId(className = Estado.class, fieldName = "id")
    private Estado estado;
    private @NotBlank String cidade;
    private @NotBlank String endereco;
    @Pattern(regexp = "\\d{5}\\-\\d{3}" ,message = "CEP inválido")
    @NotBlank
    private String cep;
    private @NotBlank String complemento;

    public Compra(){}

    public Compra(@NotBlank String nome, @NotBlank String sobrenome, @Email @NotBlank String email,
                  @NotBlank String documento, @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}\\-\\d{4}$",
            message = "Telefone inválido") @NotBlank String telefone, @NotNull Pais pais, @NotBlank String cidade, @NotBlank String endereco,
                  @Pattern(regexp = "\\d{5}\\-\\d{3}", message = "CEP inválido") @NotBlank String cep,
                  @NotBlank String complemento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.telefone = telefone;
        this.pais = pais;
        this.cidade = cidade;
        this.endereco = endereco;
        this.cep = cep;
        this.complemento = complemento;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getComplemento() {
        return complemento;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }
}
