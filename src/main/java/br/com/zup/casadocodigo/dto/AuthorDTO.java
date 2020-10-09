package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.annotations.UniqueValue;
import br.com.zup.casadocodigo.domain.Author;
import br.com.zup.casadocodigo.annotations.ExistsValue;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class AuthorDTO {

    @NotBlank(message = "is required")
    private String name;

    @NotBlank(message = "is required") @Email(message = "Invalid email address")
    @UniqueValue(domainClass = Author.class, fieldName = "email", message = "already registered")
    private String email;

    @NotBlank(message = "is required") @Size(max = 400, message = "400 caracteres")
    private String description;

    @Deprecated
    public AuthorDTO(){

    }

    public AuthorDTO(@NotBlank String name,
                            @NotBlank @Email String email,
                            @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Author transformAuthor(){
        Author author = new Author(this.name, this.email, this.description);
        return author;
    }
}
