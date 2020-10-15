package br.com.carlos.casadocodigo.domain.entity;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=100)
    private String nome;

    @Column(nullable=false, length=100, unique=true)
    private String email;

    @Column(nullable=false, length=400)
    private String descricao;

    @CreationTimestamp
    private Date timestamp;

    @Deprecated
    public Autor(){}

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
