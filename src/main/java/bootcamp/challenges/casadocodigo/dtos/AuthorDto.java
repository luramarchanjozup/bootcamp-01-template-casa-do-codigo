package bootcamp.challenges.casadocodigo.dtos;

import bootcamp.challenges.casadocodigo.entities.Author;
import bootcamp.challenges.casadocodigo.validators.EntityValueExists;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// Total Intrinsic Load Points: 2
public class AuthorDto {
    @NotBlank
    private final String name;
    @NotBlank
    @Email
    @EntityValueExists(entityClass = Author.class, entityFieldName = "email", message = "já existe e não pode ser duplicado.") // 1 - EntityUniqueValue
    private final String email;
    @NotBlank
    @Size(max = 400)
    private final String description;

    public AuthorDto(@NotBlank String name, @NotBlank @Email String email, @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Author toModel(){
        return new Author(name, email, description); // 1 - Author
    }

    public AuthorDto fromModel(Author author){
        return new AuthorDto(author.getName(),author.getEmail(), author.getDescription());
    }
}
