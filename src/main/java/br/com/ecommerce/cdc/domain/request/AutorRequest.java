package br.com.ecommerce.cdc.domain.request;

import br.com.ecommerce.cdc.anotacao.NotDuplicated;
import br.com.ecommerce.cdc.domain.model.Autor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Carga intrínseca máxima permitida - 9
 * Carga intrínseca da classe - 1
 */

public class AutorRequest {
    @NotBlank
    private String nome;
    @NotBlank @Email @NotDuplicated(fieldName = "email", nameClass = "Autor")
    private String email;
    @NotBlank @Size(max = 400)
    private String descricao;

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public String email(){
        return getEmail();
    }

    // +1
    public Autor toModel(){
        LocalDateTime instant = LocalDateTime.now(ZoneId.of("UTC"));
        return new Autor(this.nome,this.email,this.descricao, instant);
    }
}
