package bootcamp.challenges.casadocodigo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

// Total Intrinsic Load Points: 0?
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String name;
    @NotBlank
    @Email
    @Column(nullable = false)
    private String email;
    @NotBlank
    @Size(max = 400)
    @Column(length = 400)
    private String description;
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Deprecated
    public Author (){}

    public Author(@NotBlank String name, @NotBlank @Email String email, @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }
    @JsonIgnore
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    @JsonIgnore
    public String getEmail() {
        return email;
    }
    @JsonIgnore
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
