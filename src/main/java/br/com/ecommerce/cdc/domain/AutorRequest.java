package br.com.ecommerce.cdc.domain;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class AutorRequest {
    @NotBlank
    private String name;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(max = 400)
    private String description;

    public AutorRequest(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public String email(){
        return getEmail();
    }

    public Autor toModel(){
        LocalDateTime instant = LocalDateTime.now(ZoneId.of("UTC"));
        return new Autor(this.name,this.email,this.description, instant);
    }
}
