package br.com.casadocodigo.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

    /*  pontos de dificuldade de entendimento =  1 */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String email;

    @NotBlank
    private String name;

    /* @complexidade (1) - acoplamento contextual */
    @OneToMany(mappedBy = "author")
    private Set<Book> books = new HashSet<>();

    @NotBlank
    @Size(max = 400)
    private String description;

    @NotNull
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @Deprecated
    public Author(){};

    public Author(String email, String name, String description){
        this.email = email;
        this.name = name;
        this.description = description;
        this.createdAt = OffsetDateTime.now();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
