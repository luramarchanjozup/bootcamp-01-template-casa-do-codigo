package com.bootcamp.cdd.request;


import com.bootcamp.cdd.models.Country;
import com.bootcamp.cdd.models.Shopping;
import com.bootcamp.cdd.models.State;
import com.bootcamp.cdd.shared.ExistsId;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ShoppingRequest {
    @NotBlank(message = "O email deve ser preenchido")
    @Email(message = "O email foi preenchido de forma incorreta")
    private String email;
    @NotBlank(message = "O nome deve ser preenchido")
    private String nome;
    @NotBlank(message = "O sobrenome deve ser preenchido")
    private String sobrenome;
    @NotBlank(message = "O documento deve ser preenchido")
    private String documento;
    @NotBlank(message = "O endereco deve ser preenchido")
    private String endereco;
    @NotBlank(message = "O complemento deve ser preenchido")
    private String complemento;
    @NotBlank(message = "A cidade deve ser preenchido")
    private String cidade;
    @ExistsId(domainClass = State.class, fieldName = "id")
    private Long estadoId;
    @ExistsId(domainClass = Country.class, fieldName = "id")
    private long paisId;
    @NotBlank(message = "O telefone deve ser preenchido")
    private String telefone;
    @NotBlank(message = "O cep deve ser preenchido")
    private String cep;

    public ShoppingRequest(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long estadoId, long paisId, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estadoId = estadoId;
        this.paisId = paisId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getDocumento() {
        return documento;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public long getPais() {
        return paisId;
    }

    public Shopping toModel () {
        return new Shopping(this.email, this.nome, this. sobrenome, this.documento, this.endereco, this.complemento, this.cidade, this.telefone, this.cep);
    }
}
