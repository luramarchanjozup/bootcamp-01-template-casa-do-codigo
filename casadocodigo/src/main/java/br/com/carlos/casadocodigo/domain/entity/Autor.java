package br.com.carlos.casadocodigo.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "autores")
public class Autor {

    @Id @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(nullable=false, length=100)
    private String nome;

    @Getter @Setter
    @Column(nullable=false, length=100, unique=true)
    private String email;

    @Getter @Setter
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
}
