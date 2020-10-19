package dev.arielalvesdutrazup.cdc.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.Objects;

// ZERO
@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{nome.notempty}")
    private String nome;
    @Email(message = "{email.email}")
    @NotBlank(message = "{email.notempty}")
    private String email;
    @Column(columnDefinition = "TEXT")
    @Size(max = 400, message = "{descricao.max}")
    @NotBlank(message = "{descricao.notempty}")
    private String descricao;
    private OffsetDateTime cadastradoEm = OffsetDateTime.now();

    public Long getId() {
        return id;
    }

    public Autor setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Autor setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Autor setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public OffsetDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public Autor setCadastradoEm(OffsetDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
        return this;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", criadoEm=" + cadastradoEm +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
